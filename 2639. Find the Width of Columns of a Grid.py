# Medium
# Array?
# Time:O(m*n), Space:O(n) 
# https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid/

from typing import *

class Solution:
    def findColumnWidth(self, grid: List[List[int]]) -> List[int]:
        row = len(grid)
        col = len(grid[0])
        res = []

        for c in range(col):
            max_width = 0
            for r in range(row):
                width = len(str(grid[r][c])) # incl "-"
                max_width = max(max_width, width)
            res.append(max_width)
        
        return res
