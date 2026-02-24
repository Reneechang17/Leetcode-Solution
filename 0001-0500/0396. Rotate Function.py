# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        n = len(nums)
        total = sum(nums)

        f = sum(i * nums[i] for i in range(n))
        max_f = f

        for i in range(1, n):
            f = f + total - n * nums[n - i]
            max_f = max(max_f, f)
        
        return max_f
    