# Time:O(n² × L), Space:O(n²) 

from typing import List

class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        n = len(strs)
        graph = [[] for _ in range(n)]
        vis = [False] * n

        def is_similar(a, b):
            if a == b:
                return True
            diff = []
            for i in range(len(a)):
                if a[i] != b[i]:
                    diff.append(i)
                    # they can't swap
                    if len(diff) > 2:
                        return 
            return len(diff) == 2 and a[diff[0]] == b[diff[1]] and a[diff[1]] == b[diff[0]]

        for i in range(n):
            for j in range(i + 1, n):
                if is_similar(strs[i], strs[j]):
                    graph[i].append(j)
                    graph[j].append(i)
        
        def dfs(u):
            vis[u] = True
            for v in graph[u]:
                if not vis[v]:
                    dfs(v)

        cnt = 0
        for i in range(n):
            if not vis[i]:
                dfs(i)
                cnt += 1
        
        return cnt 
    