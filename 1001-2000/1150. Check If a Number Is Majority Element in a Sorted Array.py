# Time:O(logn), Space:O(1)

from typing import List

class Solution:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        n = len(nums)

        left, right = 0, n - 1
        first = -1

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                first = mid
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        if first == -1:
            return False

        return first + n // 2 < n and nums[first + n // 2] == target
    