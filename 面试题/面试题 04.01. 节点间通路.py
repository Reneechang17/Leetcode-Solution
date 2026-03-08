# Time:O(V+E), Space:O(V+E)

from collections import defaultdict, deque
from typing import List

class Solution:
    def findWhetherExistsPath(self, n: int, graph: List[List[int]], start: int, target: int) -> bool:
        adj = defaultdict(list)
        for u, v in graph:
            adj[u].append(v)
        
        vis = [False] * n
        que = deque([start])
        vis[start] = True

        while que:
            node = que.popleft()
            if node == target:
                return True
            for nei in adj[node]:
                if not vis[nei]:
                    vis[nei] = True
                    que.append(nei)
        return False
    