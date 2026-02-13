# Time:O(n*budget), Space:O(budget)

from typing import List

class Solution:
    def maximumProfit(self, present: List[int], future: List[int], budget: int) -> int:
        n = len(present)
        dp = [0] * (budget + 1)

        for i in range(n):
            cost = present[i]
            profit = future[i] - present[i]
            if profit <= 0:
                continue
            
            for b in range(budget, cost - 1, -1):
                dp[b] = max(dp[b], dp[b - cost] + profit)
        
        return dp[budget]
    