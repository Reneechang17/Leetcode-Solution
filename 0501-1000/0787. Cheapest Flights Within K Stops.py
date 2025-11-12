# Medium
# BFS
# Time:O(k × E), Space:O(n + E)
# https://leetcode.cn/problems/cheapest-flights-within-k-stops/

from typing import *

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        from collections import defaultdict, deque

        graph = defaultdict(list)
        for u, v, price in flights:
            graph[u].append((v, price))

        # BFS(cur city, city expense)
        que = deque([(src, 0)])
        min_cost = [float('inf')] * n
        stops = 0

        while que and stops <= k:
            size = len(que)

            for _ in range(size):
                city, cost = que.popleft()

                for nxt_city, price in graph[city]:
                    new_cost = cost + price

                    if new_cost < min_cost[nxt_city]:
                        min_cost[nxt_city] = new_cost
                        que.append((nxt_city, new_cost))
            
            stops += 1
        
        return min_cost[dst] if min_cost[dst] != float('inf') else -1
    