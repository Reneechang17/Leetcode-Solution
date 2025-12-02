# Hard
# In-place Hashing
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/first-missing-positive/

from typing import *

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)

        # put number in the "correct" position
        # number i should be placed in index i-1
        for i in range(n):
            while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
                # swap
                exp_idx = nums[i] - 1
                nums[i], nums[exp_idx] = nums[exp_idx], nums[i]
        
        # find the number not place in the correct place
        for i in range(n):
            if nums[i] != i + 1: # nums[i] should place in i+1
                return i + 1
        
        # if all in the correct place
        return n + 1
    