# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        restricted_set = set(restricted)
        vis = set([0])
        count = 0

        def dfs(node):
            nonlocal count
            count += 1

            for neighbor in graph[node]:
                if neighbor not in vis and neighbor not in restricted_set:
                    vis.add(neighbor)
                    dfs(neighbor)

        dfs(0)
        return count
