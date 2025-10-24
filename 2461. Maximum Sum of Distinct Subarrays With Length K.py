from typing import *

class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        if k > n:
            return 0
        
        window = set() # record window' elements
        window_sum = 0
        max_sum = 0
        left = 0

        for right in range(n):
            # check dup: if nums[right] in window, shrink left
            while nums[right] in window:
                window.remove(nums[left])
                window_sum -= nums[left]
                left += 1

            # add current
            window.add(nums[right])
            window_sum += nums[right]

            if right - left + 1 == k:
                max_sum = max(max_sum, window_sum)
                window.remove(nums[left])
                window_sum -= nums[left]
                left += 1
        
        return max_sum
