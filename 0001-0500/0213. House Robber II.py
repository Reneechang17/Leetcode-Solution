
from typing import *

# two cases: rob[0, n-2](don't rob last one)
# or rob[1, n-1](don't rob first one)

class Solution:
    def rob(self, nums: List[int]) -> int:
        # base
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)
        
        def helper(arr):
            prev2, prev1 = 0, 0
            for x in arr:
                cur = max(prev1, prev2 + x)
                prev2, prev1 = prev1, cur
            return prev1
        
        c1 = helper(nums[:-1])
        c2 = helper(nums[1:])
        return max(c1, c2)
