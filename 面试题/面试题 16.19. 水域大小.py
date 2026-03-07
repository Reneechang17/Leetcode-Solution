# Time:O(mn), Space:O(mn)

from typing import List

class Solution:
    def pondSizes(self, land: List[List[int]]) -> List[int]:
        m, n = len(land), len(land[0])
        res = []
        dirs = [(0,1),(1,0),(0,-1),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1)]

        def dfs(i, j):
            if i < 0 or i >= m or j < 0 or j >= n or land[i][j] != 0:
                return 0
            land[i][j] = -1 # mark as vis
            size = 1
            for dx, dy in dirs:
                size += dfs(i + dx, j + dy)
            
            return size

        for i in range(m):
            for j in range(n):
                if land[i][j] == 0:
                    res.append(dfs(i, j))
        
        return sorted(res)
    