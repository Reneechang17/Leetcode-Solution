# Time:O(logn), Space:O(1)

from typing import List

class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        def first_non_neg():
            l, r = 0, len(nums)
            while l < r:
                mid = (l + r) // 2
                if nums[mid] < 0:
                    l = mid + 1
                else:
                    r = mid
            return l

        def first_pos():
            l, r = 0, len(nums)
            while l < r:
                mid = (l + r) // 2
                if nums[mid] <= 0:
                    l = mid + 1
                else:
                    r = mid
            return l
        
        neg_count = first_non_neg()
        pos_count = len(nums) - first_pos()
        return max(neg_count, pos_count)
    