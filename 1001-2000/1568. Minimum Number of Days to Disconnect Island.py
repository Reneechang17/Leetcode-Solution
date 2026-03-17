# Time:O((m × n)²), Space:O(m * n)

from typing import List

class Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]

        def count_island():
            vis = [[False] * n for _ in range(m)]

            def dfs(i, j):
                vis[i][j] = True
                for dx, dy in dirs:
                    x, y = i + dx, j + dy
                    if 0 <= x < m and 0 <= y < n and grid[x][y] == 1 and not vis[x][y]:
                        dfs(x, y)

            cnt = 0
            for i in range(m):
                for j in range(n):
                    if grid[i][j] == 1 and not vis[i][j]:
                        dfs(i, j)
                        cnt += 1
            
            return cnt
        
        # already disconnected
        if count_island() != 1:
            return 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    grid[i][j] = 0
                    if count_island() != 1:
                        return 1
                    grid[i][j] = 1
        
        return 2
    