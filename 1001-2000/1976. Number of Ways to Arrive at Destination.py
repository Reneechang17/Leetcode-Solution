# Time:O(ElogV), Space:O(V+E)

import heapq
from typing import List

class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        MOD = 10**9 + 7

        graph = [[] for _ in range(n)]
        for u, v, time in roads:
            graph[u].append((v, time))
            graph[v].append((u, time))

        dist = [float("inf")] * n
        ways = [0] * n
        dist[0] = 0
        ways[0] = 1

        heap = [(0, 0)]  # (dist, node)

        while heap:
            d, node = heapq.heappop(heap)

            if d > dist[node]:
                continue

            for neighbor, time in graph[node]:
                new_dist = d + time

                if new_dist < dist[neighbor]:
                    dist[neighbor] = new_dist
                    ways[neighbor] = ways[node]
                    heapq.heappush(heap, (new_dist, neighbor))
                elif new_dist == dist[neighbor]:
                    ways[neighbor] = (ways[neighbor] + ways[node]) % MOD

        return ways[n - 1]
    