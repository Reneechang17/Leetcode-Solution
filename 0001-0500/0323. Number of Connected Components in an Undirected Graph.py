# Time:O(n+m), Space:O(n+m)

from typing import List

class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)
        
        vis = [False] * n

        def dfs(node):
            vis[node] = True
            for nei in graph[node]:
                if not vis[nei]:
                    dfs(nei)

        cnt = 0
        for i in range(n):
            if not vis[i]:
                dfs(i)
                cnt += 1
        
        return cnt
    