# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ops = 0

        for i in range(len(nums) - 2):
            if nums[i] == 0:
                nums[i] ^= 1
                nums[i + 1] ^= 1
                nums[i + 2] ^= 1
                ops += 1
        
        if nums[-2] == 1 and nums[-1] == 1:
            return ops

        return -1
    