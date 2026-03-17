# Time:O(k × E), Space:O(n + E)

from typing import List
from collections import defaultdict, deque

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for u, v, p in flights:
            graph[u].append((v, p))
        
        que = deque([(src, 0)]) # cur city, cost to cur city
        min_cost = [float('inf')] * n
        stops = 0

        while que and stops <= k:
            size = len(que)
            for _ in range(size):
                city, cost = que.popleft()

                for next_city, p in graph[city]:
                    new_cost = cost + p
                    if new_cost < min_cost[next_city]:
                        min_cost[next_city] = new_cost
                        que.append((next_city, new_cost))
            stops += 1
    
        return min_cost[dst] if min_cost[dst] != float('inf') else -1
    