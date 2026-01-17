# Time:O(mnk), Space:O(mnk)

from typing import *
class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])

        dp = [[[0] * k for _ in range(n)] for _ in range(m)]
        dp[0][0][grid[0][0] % k] = 1

        for i in range(m):
            for j in range(n):
                val = grid[i][j]
                for reminder in range(k):
                    if i == 0 and j == 0:
                        continue
                    prev_reminder = (reminder - val) % k
                    paths = 0
                    if i > 0:
                        paths += dp[i - 1][j][prev_reminder]
                    if j > 0:
                        paths += dp[i][j - 1][prev_reminder]
                    dp[i][j][reminder] = paths % MOD

        return dp[m - 1][n - 1][0]
