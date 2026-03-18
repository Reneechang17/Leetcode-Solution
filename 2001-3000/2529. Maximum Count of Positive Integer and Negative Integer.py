# Time:O(logn), Space:O(1)

from typing import List

class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        n = len(nums)

        # find first >= 0
        # 负数的右边界
        left, right = 0, n
        while left < right:
            mid = (left + right) // 2
            if nums[mid] < 0:
                left = mid + 1
            else:
                right = mid
        neg_cnt = left

        # find first > 0
        # 正数的左边界
        left, right = 0, n
        while left < right:
            mid = (left + right) // 2
            if nums[mid] <= 0:
                left = mid + 1
            else:
                right = mid
        pos_cnt = n - left

        return max(neg_cnt, pos_cnt)
    