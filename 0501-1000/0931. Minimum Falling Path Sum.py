# Time:O(n²), Space:O(n²)

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [[0] * n for _ in range(n)]

        for j in range(n):
            dp[0][j] = matrix[0][j]

        for i in range(1, n):
            for j in range(n):
                min_prev = dp[i - 1][j]
                if j > 0:
                    min_prev = min(min_prev, dp[i - 1][j - 1])
                if j < n - 1:
                    min_prev = min(min_prev, dp[i - 1][j + 1])

                dp[i][j] = matrix[i][j] + min_prev

        return min(dp[n - 1])
