# Medium
# DP
# Time:O(m*n*(m+n)), Space:O(m*n*(m+n))
# https://leetcode.cn/problems/check-if-there-is-a-path-with-equal-number-of-0s-and-1s/

from typing import *

class Solution:
    def isThereAPath(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])

        # total part should be even
        if (m + n - 1) % 2 != 0:
            return False
        
        # DFS with memoization, avoid revisiting same states
        # state (row, col, balance), balance is count(1)-count(0) so far
        memo = {}

        def dfs(i, j, balance):
            if i == m or j == n:
                return False
            
            # update balance
            balance += 1 if grid[i][j] == 1 else -1

            if i == m - 1 and j == n - 1:
                return balance == 0
            
            if (i, j, balance) in memo:
                return memo[(i, j, balance)]
            
            # right or down
            res = dfs(i + 1, j, balance) or dfs(i, j + 1, balance)
            memo[(i, j, balance)] = res
            return res
        
        return dfs(0, 0, 0)
