# Time:O(nlogn+m), Space:O(n+m)

from typing import List

class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        n = len(s)
        graph = [[] for _ in range(n)]
        for a, b in pairs:
            graph[a].append(b)
            graph[b].append(a)
        
        vis = [False] * n
        res = list(s)

        for i in range(n):
            if not vis[i]:
                stack = [i]
                vis[i] = True
                indices = []
                while stack:
                    node = stack.pop()
                    indices.append(node)
                    for nei in graph[node]:
                        if not vis[nei]:
                            vis[nei] = True
                            stack.append(nei)
                
                chars = [res[idx] for idx in indices]
                chars.sort()
                indices.sort()
                for idx, c in zip(indices, chars):
                    res[idx] = c
        
        return ''.join(res)
    