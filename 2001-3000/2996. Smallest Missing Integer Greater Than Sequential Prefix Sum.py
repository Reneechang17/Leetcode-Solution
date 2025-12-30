# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        prefix_sum = nums[0]
        i = 1

        while i < len(nums) and nums[i] == nums[i - 1] + 1:
            prefix_sum += nums[i]
            i += 1
        
        nums_set = set(nums)
        res = prefix_sum

        while res in nums_set:
            res += 1
        
        return res
    