# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        if len(nums) == 1:
            return nums[0]

        prev2, prev1 = 0, 0
        for x in nums:
            cur = max(prev1, prev2 + x)
            prev2 = prev1
            prev1 = cur

        return prev1
