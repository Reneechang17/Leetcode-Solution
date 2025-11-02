# Medium
# Matrix
# Time:O(m*n), Space:O(n) -> col_hits
# https://leetcode.cn/problems/bomb-enemy/

from typing import *

class Solution:
    def maxKilledEnemies(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        m, n = len(grid), len(grid[0])
        max_enemies = 0
        row_hits = 0
        col_hits = [0] * n

        for i in range(m):
            for j in range(n):
                if j == 0 or grid[i][j - 1] == 'W':
                    row_hits = 0
                    for k in range(j, n):
                        if grid[i][k] == 'W':
                            break
                        if grid[i][k] == 'E':
                            row_hits += 1
                if i == 0 or grid[i - 1][j] == 'W':
                    col_hits[j] = 0
                    for k in range(i, m):
                        if grid[k][j] == 'W':
                            break
                        if grid[k][j] == 'E':
                            col_hits[j] += 1
                
                if grid[i][j] == '0':
                    max_enemies = max(max_enemies, row_hits + col_hits[j])
        return max_enemies
