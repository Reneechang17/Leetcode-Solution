# Medium
# Greedy
# Time:O(m+n), Space:O(1) 
# https://leetcode.cn/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

from typing import *

class Solution:
    def minCost(self, startPos: List[int], homePos: List[int], rowCosts: List[int], colCosts: List[int]) -> int:
        start_row, start_col = startPos
        home_row, home_col = homePos

        total = 0

        if start_row < home_row:
            # going down
            for i in range(start_row + 1, home_row + 1):
                total += rowCosts[i]
        else:
            # going up
            # -1 means go through from tail
            for i in range(start_row - 1, home_row - 1, -1):
                total += rowCosts[i]
            
        if start_col < home_col:
            # going right
            for j in range(start_col + 1, home_col + 1):
                total += colCosts[j]
        else:
            # going left
            for j in range(start_col - 1, home_col - 1, -1):
                total += colCosts[j]
        
        return total
    