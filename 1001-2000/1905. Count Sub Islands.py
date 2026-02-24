# Time:O(mn), Space:O(mn)

from typing import List

class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        # DFS grid2 and check if all cells are 1 in grid1
        m, n = len(grid1), len(grid1[0])
        dirs = [(0,1), (1,0), (0,-1), (-1,0)]

        def dfs(i, j):
            if i < 0 or i >= m or j < 0 or j >= n or grid2[i][j] == 0:
                return True

            grid2[i][j] = 0
            is_sub = (grid1[i][j] == 1)

            for dx, dy in dirs:
                is_sub = dfs(i + dx, j + dy) and is_sub
            return is_sub

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid2[i][j] == 1 and dfs(i, j):
                    ans += 1
        
        return ans
    