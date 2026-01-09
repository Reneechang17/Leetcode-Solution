# Time:O(mn), Space:O(1)

from typing import List

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        perimeter = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                        ni, nj = i + di, j + dj
                        if ni < 0 or ni >= m or nj < 0 or nj >= n or grid[ni][nj] == 0:
                            perimeter += 1

        return perimeter
