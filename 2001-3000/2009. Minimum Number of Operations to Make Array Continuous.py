# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        nums = sorted(set(nums))
        m = len(nums)

        j = 0
        max_window = 0
        for i in range(m):
            while j < m and nums[j] - nums[i] < n:
                j += 1
            max_window = max(max_window, j - i)
        
        return n - max_window
    