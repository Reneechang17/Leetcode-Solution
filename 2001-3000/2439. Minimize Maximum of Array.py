# TODO: Need to think more :>

# Time:O(nlogM), Space:O(1)

from typing import List

class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        left, right = 0, max(nums)

        def can_do(t):
            total = 0
            for i, num in enumerate(nums):
                total += num
                if total > t * (i + 1):
                    return False

            return True

        while left < right:
            mid = (left + right) // 2
            if can_do(mid):
                right = mid
            else:
                left = mid + 1
        
        return left
    