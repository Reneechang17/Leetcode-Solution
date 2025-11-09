
from typing import *

# two options: rob cur(dp[i-2] + nums[i]) or not(keep dp[i - 1])
# Time:O(n), Space:O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        # base
        if not nums:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        prev2 = nums[0]
        prev1 = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            cur = max(prev1, prev2 + nums[i])
            prev2 = prev1
            prev1 = cur
        
        return prev1  # last one dp[n-1]  
        