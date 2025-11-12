# Medium
# Matrix
# Time:O(m*n*g), Space:O(m*n)
# https://leetcode.cn/problems/count-unguarded-cells-in-the-grid/

from typing import *

class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        grid = [[0] * n for _ in range(m)]

        for r, c in guards:
            grid[r][c] = 1
        for r, c in walls:
            grid[r][c] = 2
        
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for gr, gc in guards:
            for dr, dc in directions:
                r, c = gr + dr, gc + dc
                while 0 <= r < m and 0 <= c < n:
                    if grid[r][c] == 1 or grid[r][c] == 2:
                        break
                    grid[r][c] = 3
                    r += dr
                    c += dc
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    count += 1

        return count
