# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)

        dp = [[0] * 3 for _ in range(n)]

        dp[0] = costs[0]

        for i in range(1, n):
            # red -> prev should be blue or green
            dp[i][0] = costs[i][0] + min(dp[i - 1][1], dp[i - 1][2])
            # blue -> prev should be red or green
            dp[i][1] = costs[i][1] + min(dp[i - 1][0], dp[i - 1][2])
            # green -> prev should be red or blue
            dp[i][2] = costs[i][2] + min(dp[i - 1][0], dp[i - 1][1])

        return min(dp[n - 1])
    