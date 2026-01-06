# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        left = 0
        window_or = 0
        max_len = 0

        for right in range(len(nums)):
            while window_or & nums[right] != 0:
                window_or ^= nums[left]
                left += 1

            window_or |= nums[right]
            max_len = max(max_len, right - left + 1)

        return max_len
