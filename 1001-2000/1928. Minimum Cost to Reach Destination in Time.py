# Time:O(maxTime × E), Space: O(n × maxTime)

from typing import List
import heapq

class Solution:
    def minCost(self, maxTime: int, edges: List[List[int]], passingFees: List[int]) -> int:
        n = len(passingFees)

        graph = [[] for _ in range(n)]
        for u, v, t in edges:
            graph[u].append((v, t))
            graph[v].append((u, t))
        
        heap = [(passingFees[0], 0, 0)]

        best = [[float('inf')] * (maxTime + 1) for _ in range(n)]
        best[0][0] = passingFees[0]

        while heap:
            cost, time, city = heapq.heappop(heap)

            if city == n - 1:
                return cost
            
            for neighbor, travel_time in graph[city]:
                new_time = time + travel_time
                new_cost = cost + passingFees[neighbor]

                if new_time > maxTime:
                    continue
                
                if new_cost < best[neighbor][new_time]:
                    best[neighbor][new_time] = new_cost
                    heapq.heappush(heap, (new_cost, new_time, neighbor))
        
        return -1
    