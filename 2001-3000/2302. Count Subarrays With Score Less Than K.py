# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left = 0
        cur_sum = 0
        ans = 0

        for right in range(n):
            cur_sum += nums[right]

            while cur_sum * (right - left + 1) >= k:
                cur_sum -= nums[left]
                left += 1
                # nothing in window
                if left > right:
                    break
            
            ans += right - left + 1
            
        return ans 
    