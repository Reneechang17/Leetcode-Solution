# Hard
# DP
# Time:O(mnk), Space:O(mnk)
# https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k/

from typing import *

class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])

        # dp[i][j][r] = routes sum from (i, j) % k = r
        dp = [[[0] * k for _ in range(n)] for _ in range(m)]
        dp[0][0][grid[0][0] % k] = 1

        for i in range(m):
            for j in range(n):
                for r in range(k):
                    if dp[i][j][r] == 0:
                        continue
                    
                    # go right
                    if j + 1 < n:
                        new_r = (r + grid[i][j + 1]) % k
                        dp[i][j + 1][new_r] = (dp[i][j + 1][new_r] + dp[i][j][r]) % MOD
                    # go down
                    if i + 1 < m:
                        new_r = (r + grid[i + 1][j]) % k
                        dp[i + 1][j][new_r] = (dp[i + 1][j][new_r] + dp[i][j][r]) % MOD
        
        return dp[m - 1][n - 1][0]
