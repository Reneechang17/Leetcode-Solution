# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        nums.sort()
        left, right = 0, len(nums) - 1
        max_sum = -1

        while left < right:
            total = nums[left] + nums[right]

            if total < k:
                max_sum = max(max_sum, total)
                left += 1
            else:
                right -= 1

        return max_sum
