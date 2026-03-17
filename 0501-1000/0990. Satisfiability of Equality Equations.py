# Time:O(n+26), Space:O(26²)-> graph

from typing import List

class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        graph = [[] for _ in range(26)]

        for eq in equations:
            if eq[1] == '=':
                a = ord(eq[0]) - ord('a')
                b = ord(eq[3]) - ord('a')
                graph[a].append(b)
                graph[b].append(a)
        
        vis = [-1] * 26

        def dfs(u, c):
            vis[u] = c
            for v in graph[u]:
                if vis[v] == -1:
                    dfs(v, c)

        c = 0
        for i in range(26):
            if vis[i] == -1:
                dfs(i, c)
                c += 1
        
        for eq in equations:
            if eq[1] == '!':
                a = ord(eq[0]) - ord('a')
                b = ord(eq[3]) - ord('a')
                if vis[a] == vis[b]:
                    return False
        
        return True
    