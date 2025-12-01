
from typing import *

# two options: rob cur(dp[i-2] + nums[i]) or not(keep dp[i - 1])
# Time:O(n), Space:O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev2 = 0 # dp[i-2]
        prev1 = 0 # dp[i-1]

        for num in nums:
            cur = max(prev1, prev2 + num)
            prev2 = prev1
            prev1 = cur
        return prev1
