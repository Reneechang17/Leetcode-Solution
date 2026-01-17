# Time:O(N*S), Space:O(N*S)

from collections import defaultdict, deque
from typing import List

class Solution:
    def numBusesToDestination(
        self, routes: List[List[int]], source: int, target: int
    ) -> int:
        if source == target:
            return 0

        stop_to_routes = defaultdict(list)
        for i, route in enumerate(routes):
            for stop in route:
                stop_to_routes[stop].append(i)

        que = deque()
        vis = set()

        for route_id in stop_to_routes[source]:
            que.append((route_id, 1))
            vis.add(route_id)

        while que:
            route_id, buses = que.popleft()

            if target in routes[route_id]:
                return buses

            for stop in routes[route_id]:
                for next_route in stop_to_routes[stop]:
                    if next_route not in vis:
                        vis.add(next_route)
                        que.append((next_route, buses + 1))

        return -1
    