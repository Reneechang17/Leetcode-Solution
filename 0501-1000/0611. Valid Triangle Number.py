# Time:O(n²), Space:O(1)

from typing import List

class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        count = 0
        n = len(nums)

        for k in range(n - 1, -1, -1):
            left, right = 0, k - 1

            while left < right:
                if nums[left] + nums[right] > nums[k]:
                    count += right - left
                    right -= 1
                else:
                    left += 1

        return count
