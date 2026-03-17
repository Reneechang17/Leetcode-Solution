# Time:O(n²), Space:O(n)

from typing import List

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        vis = [False] * n

        def dfs(c):
            vis[c] = True
            for nei in range(n):
                if isConnected[c][nei] == 1 and not vis[nei]:
                    dfs(nei)

        provinces = 0
        for i in range(n):
            if not vis[i]:
                dfs(i)
                provinces += 1
        
        return provinces
    