# Time:O(n),Space:O(1)

from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        left = 0
        cur_sum = 0
        ans = float('inf')

        for right in range(n):
            cur_sum += nums[right]

            while cur_sum >= target:
                ans = min(ans, right - left + 1)
                cur_sum -= nums[left]
                left += 1
        
        return ans if ans != float('inf') else 0
    