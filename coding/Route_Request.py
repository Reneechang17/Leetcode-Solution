def route_request(numTargets, maxConnectionsPerTarget, requests):
    # ---------------- Part 0: init state ----------------
    n, cap = numTargets, maxConnectionsPerTarget
    load = [0] * n                       # 每台机的活跃连接数
    conn = {}                            # cid -> (t, uid, oid)
    tgt_cids = [set() for _ in range(n)] # 每台机上的连接ID集合
    obj_t = {}                           # oid -> 绑定的目标机 t
    obj_cnt = {}                         # oid -> 活跃连接计数
    disabled = set()                     # 暂时禁用的目标机
    logs = []                            # 仅记录 CONNECT 日志
    arrive = {}                          # cid 的首次出现顺序
    seq = 0

    # 选择未禁用且未满载的“最小负载，平手取小下标”的目标机
    def pick_target(exclude_disabled=True):
        best_t, best_load = None, None
        for t in range(n):
            if exclude_disabled and t in disabled:
                continue
            if load[t] >= cap:
                continue
            if best_t is None or load[t] < best_load or (load[t] == best_load and t < best_t):
                best_t, best_load = t, load[t]
        return best_t

    # ---------------- Part 1: CONNECT ----------------
    def attach(cid, uid, oid):
        if oid in obj_t:
            t = obj_t[oid]
            if t in disabled or load[t] >= cap:
                return False
        else:
            t = pick_target()
            if t is None:
                return False

        conn[cid] = (t, uid, oid)
        tgt_cids[t].add(cid)
        load[t] += 1
        obj_cnt[oid] = obj_cnt.get(oid, 0) + 1
        obj_t[oid] = t
        logs.append(f"{cid},{uid},{t+1}")
        return True

    # ---------------- Part 2: DISCONNECT ----------------
    def detach(cid):
        rec = conn.pop(cid, None)
        if not rec:
            return
        t, _, oid = rec
        if cid in tgt_cids[t]:
            tgt_cids[t].remove(cid)
        load[t] -= 1
        k = obj_cnt.get(oid, 0) - 1
        if k <= 0:
            obj_cnt.pop(oid, None)
            obj_t.pop(oid, None)
        else:
            obj_cnt[oid] = k

    # ---------------- Part 3/4/5: main loop (CONNECT / DISCONNECT / SHUTDOWN) ----------------
    for line in requests:
        parts = [x.strip() for x in line.split(",")]
        op = parts[0]

        if op == "CONNECT":
            _, cid, uid, oid = parts
            if cid not in arrive:
                seq += 1
                arrive[cid] = seq
            attach(cid, uid, oid)

        elif op == "DISCONNECT":
            _, cid, *_ = parts
            if cid in conn:
                detach(cid)

        else:  # SHUTDOWN,targetIndex
            _, idx = parts
            t = int(idx) - 1
            disabled.add(t)

            # 逐连接按“首次出现顺序”驱逐并重连
            evict = sorted(
                [cid for cid in tgt_cids[t] if cid in conn and conn[cid][0] == t],
                key=lambda c: (arrive.get(c, float("inf")), c)
            )
            to_reconnect = [(cid, conn[cid][1], conn[cid][2]) for cid in evict]
            for cid in evict:
                detach(cid)
            tgt_cids[t].clear()
            for cid, uid, oid in to_reconnect:
                attach(cid, uid, oid)

            disabled.discard(t)

    return logs
