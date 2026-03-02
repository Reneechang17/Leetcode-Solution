# Time:O(4^(max_time/10))
# Space:O(n+m)

from collections import defaultdict
from typing import List

class Solution:
    def maximalPathQuality(self, values: List[int], edges: List[List[int]], maxTime: int) -> int:
        graph = defaultdict(list)
        for u, v, t in edges:
            graph[u].append((v, t))
            graph[v].append((u, t))
        
        n = len(values)
        vis = [0] * n
        self.ans = 0

        def dfs(u, time, value):
            if u == 0:
                self.ans = max(self.ans, value)
            
            for v, t in graph[u]:
                if time + t <= maxTime:
                    if not vis[v]:
                        vis[v] = 1
                        dfs(v, time + t, value + values[v])
                        vis[v] = 0
                    else:
                        # already visited
                        dfs(v, time + t, value)

        vis[0] = 1
        dfs(0, 0, values[0])
        return self.ans
    