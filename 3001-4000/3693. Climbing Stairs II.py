# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def climbStairs(self, n: int, costs: List[int]) -> int:
        if n == 0:
            return 0
        
        dp0, dp1, dp2 = 0, 0, 0 # dp[i-3], dp[i-2], dp[i-1]
        
        for i in range(1, n + 1):
            # i-1
            cur = dp2 + costs[i-1] + 1 # (i-(i-1))^2 =1

            # i-2
            if i >= 2:
                cur = min(cur, dp1 + costs[i-1] + 4) # (i-(i-2))^2 =4
            
            # i-3
            if i >= 3:
                cur = min(cur, dp0 + costs[i-1] + 9) # (i-(i-3))^2 =9
            
            dp0, dp1, dp2 = dp1, dp2, cur
        
        return dp2
    