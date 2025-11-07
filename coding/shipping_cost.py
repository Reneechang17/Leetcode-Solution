from collections import defaultdict
import heapq

# Common parsing
def parse_input(inputString):
    ship_graph = {} # ship_graph[src] = [(dst, method, cost), ...]
    cost_lookup = {} # cost_lookup[(src, dst, method)] = cost

    if not inputString:
        return ship_graph, cost_lookup
    
    routes = inputString.split(",")
    for route in routes:
        route = route.strip()
        if not route:
            continue
        parts = route.split(":")
        if len(parts) != 4:
            # skip if invalid format
            continue

        src_country, tgt_country, method, cost_str = parts
        try:
            cost = int(cost_str)
        except ValueError:
            # skip if cost is not integer
            continue

        ship_graph.setdefault(src_country, []).append(
            (tgt_country, method, cost)
        )
        cost_lookup[(src_country, tgt_country, method)] = cost

    return ship_graph, cost_lookup

# Part 1: give src, dst, method, find cost
def travel_cost(inputString, src_country, tgt_country, method):
    ship_graph, cost_lookup = parse_input(inputString)

    cost = cost_lookup.get((src_country, tgt_country, method))
    if cost is None:
        return -1
    
    return cost

# Part 2: Find route could be directly or at most once mid transfer
def travel_route(inputString, src_country, tgt_country):
    ship_graph, _ = parse_input(inputString)

    if src_country not in ship_graph:
        return None
    
    # first to check directly
    for dst, m, c in ship_graph[src_country]:
        if dst == tgt_country:
            return {
                "route": [src_country, tgt_country],
                "method": [m],
                "cost": c
            }
    
    # then check mid transfer
    for mid, m1, c1, in ship_graph[src_country]:
        if mid not in ship_graph:
            continue
        for dst, m2, c2 in ship_graph[mid]:
            if dst == tgt_country:
                return {
                    "route": [src_country, mid, tgt_country],
                    "method": [m1, m2],
                    "cost": c1 + c2
                }
    
    return None

# Part 3: continue Part2, find the cheapest
def travel_cheapest(inputString, src_country, tgt_country):
    ship_graph, _ = parse_input(inputString)

    if src_country not in ship_graph:
        return None
    
    best = None # (total_cost, route, methods)

    # All directly
    for dst, m, c in ship_graph[src_country]:
        if dst == tgt_country:
            cand = (c, [src_country, tgt_country], [m])
            if best is None or c < best[0]:
                best = cand
    
    # Mid
    for mid, m1, c1 in ship_graph[src_country]:
        if mid not in ship_graph:
            continue
        for dst, m2, c2 in ship_graph[mid]:
            if dst == tgt_country:
                total = c1 + c2
                cand = (total, [src_country, mid, tgt_country], [m1, m2])
                if best is None or total < best[0]:
                    best = cand
    
    if best is None:
        return None
    
    total, route, methods = best
    return {
        "route": route,
        "method": methods,
        "cost": total
    }

# Part 4: Cheapest route with any times mid transfer
# Use pq and find by cost, make sure not do the same path to avoid dead cycle
def travel_cheapest_any_transfer(inputString, src_country, tgt_country):
    ship_graph, _ = parse_input(inputString)

    if src_country not in ship_graph:
        return None
    
    # (cost_so_far, node, path, methods)
    heap = [(0, src_country, [src_country], [])]
    vis = set()

    while heap:
        cost, node, path, methods = heapq.heappop(heap)

        if node == tgt_country:
            return {"path": path, "method": methods, "cost": cost}
        
        if (node, len(path)) in vis:
            continue
        vis.add((node, len(path)))
        
        for next, m, c in ship_graph.get(node, []):
            if next in path:
                continue
            heapq.heappush(
                heap,
                (cost + c, next, path + [next], methods + [m])
            )

    return None

if __name__ == "__main__":
    inputString = "US:UK:FEDEX:5,US:CA:UPS:1,CA:FR:DHL:3,UK:FR:DHL:2,US:FR:UPS:8"

    print("Q1:")
    print(travel_cost(inputString, "US", "UK", "FEDEX"))  # 5
    print(travel_cost(inputString, "US", "FR", "UPS"))    # 8
    print(travel_cost(inputString, "US", "FR", "FEDEX"))  # -1 

    print("\nQ2:")
    print(travel_route(inputString, "US", "FR"))

    print("\nQ3:")
    inputString2 = "US:UK:FEDEX:5,US:CA:UPS:1,CA:FR:DHL:3,UK:FR:DHL:2"
    print(travel_cheapest(inputString2, "US", "FR"))

    print("\nQ4:")
    print(travel_cheapest_any_transfer(inputString2, "US", "FR"))
