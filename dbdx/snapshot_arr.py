from typing import *

ADD, REM = 1, 0 # operation markers

class SnapshotSet:
    # add(x)/remove(x) append ops for key x at the cur version
    # iterator() captures a snapshot version, future updates won't affect it
    def __init__(self, init_vals: Optional[Iterable[int]] = None):
        self._ver: int = 1 # global monotonically increasing ver
        # per-key append-only log: key->[(ver, ops)]
        self._log: Dict[int, List[Tuple[int, int]]] = {}
        if init_vals:
            for x in init_vals:
                self._append(x, ADD) 

    # public APIs
    def add(self, x: int) -> None:
        self._append(x, ADD)
    
    def remove(self, x: int) -> None:
        self._append(x, REM)
    
    def iterator(self):
        # capture the cur ver as snap_ver and freeze the key list
        # for each key, incl it iff the last op with version <= snap_ver is ADD
        snap_ver = self._ver
        self._ver += 1
        keys = list(self._log.keys()) # freeze key set
        res: List[int] = []

        def last_le_idx(ops: List[Tuple[int, int]], v: int) -> int:
            # return the idx of the last entry which version <= v, or -1 if none
            lo, hi, res = 0, len(ops) - 1, -1
            while lo <= hi:
                mid = (lo + hi) // 2
                if ops[mid][0] <= v:
                    res = mid  # record best-so-far (we want the last one)
                    lo = mid + 1
                else:
                    hi = mid - 1
            return res
        
        for k in keys: 
            ops = self._log.get(k, [])
            j = last_le_idx(ops, snap_ver)
            if j != -1 and ops[j][1] == ADD:
                # yield k
                res.append(k)
        return res 

    def _append(self, x: int, op: int) -> None:
        # append for coalesce an ops for key x at the cur version
        # if the prev ops is in the same ver, overwrite it
        lst = self._log.setdefault(x, [])
        if lst and lst[-1][0] == self._ver:
            lst[-1] = (self._ver, op) # overwrite within the same ver
        else:
            lst.append((self._ver, op))

# Lc 1146
class SnapshotArray:

    def __init__(self, length: int):
        # each index store history version [(snap_id, value)]
        self.history = [[(0, 0)] for _ in range(length)]
        self.snap_id = 0

    def set(self, index: int, value: int) -> None:
        # if cur snap_id has record -> update, otherwise -> append
        if self.history[index][-1][0] == self.snap_id:
            self.history[index][-1] = (self.snap_id, value)
        else:
            self.history[index].append((self.snap_id, value))

    def snap(self) -> int:
        self.snap_id += 1
        return self.snap_id - 1
    
    def get(self, index: int, snap_id: int) -> int:
        # binary search to find the biggest version which <= snap_id
        arr = self.history[index]
        left, right = 0, len(arr) - 1

        while left < right:
            mid = (left + right + 1) // 2
            if arr[mid][0] <= snap_id:
                left = mid
            else:
                right = mid - 1
        
        return arr[left][1]
