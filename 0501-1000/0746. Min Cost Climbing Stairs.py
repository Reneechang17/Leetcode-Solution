# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        prev2 = 0 # dp[i-2]
        prev1 = 0 # dp[i-1]
        n = len(cost)

        for i in range(2, n + 1):
            cur = min(prev1 + cost[i-1], prev2 + cost[i-2])
            prev2, prev1 = prev1, cur
        
        return prev1
    