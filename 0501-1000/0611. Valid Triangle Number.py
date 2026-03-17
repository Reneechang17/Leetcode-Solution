# Time:O(n²), Space:O(1)

from typing import List

class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        ans = 0

        # fix a side(largest one)
        for k in range(n - 1, -1, -1):
            left, right = 0, k - 1

            while left < right:
                if nums[left] + nums[right] > nums[k]:
                    ans += right - left
                    right -= 1
                else:
                    left += 1
        
        return ans
