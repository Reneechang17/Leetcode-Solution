# Time:O(m*n), Space:O(n) 

from typing import List

class Solution:
    def findColumnWidth(self, grid: List[List[int]]) -> List[int]:
        rows, cols = len(grid), len(grid[0])
        res = []

        for c in range(cols):
            max_width = 0
            for r in range(rows):
                width = len(str(grid[r][c]))
                max_width = max(max_width, width)

            res.append(max_width)

        return res
    