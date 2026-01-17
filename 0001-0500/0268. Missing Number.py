# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        xor_all = n
        for i, num in enumerate(nums):
            xor_all ^= i ^ num
        
        return xor_all
    