# Medium
# Prefix
# Time:O(mn), Space:O(1)
# https://leetcode.cn/problems/construct-product-matrix/

from typing import *

# similar to 238 but 2D

class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        MOD = 12345
        m, n = len(grid), len(grid[0])
        res = [[0] * n for _ in range(m)]

        # prefix: top-left to right-bottom
        prefix = 1
        for i in range(m):
            for j in range(n):
                res[i][j] = prefix
                prefix = (prefix * grid[i][j]) % MOD
            
        # suffix: right-bottom to top-left
        suffix = 1
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                res[i][j] = (res[i][j] * suffix) % MOD
                suffix = (suffix * grid[i][j]) % MOD
        
        return res
    