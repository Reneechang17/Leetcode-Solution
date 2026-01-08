# Time:O(n * k * m), Space:O(n * k)

from typing import List

class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        n = len(piles)
        dp = [[0] * (k + 1) for _ in range(n + 1)]

        for i in range(1, n + 1):
            pile = piles[i - 1]
            for j in range(k + 1):
                # get t' coins from pile i
                pile_sum = 0
                for t in range(min(j, len(pile)) + 1):
                    if t == 0:
                        dp[i][j] = max(dp[i][j], dp[i - 1][j])
                    else:
                        pile_sum += pile[t - 1]
                        dp[i][j] = max(dp[i][j], dp[i - 1][j - t] + pile_sum)

        return dp[n][k]
        