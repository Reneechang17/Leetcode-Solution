# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_val = max(nums)
        n = len(nums)

        ans = 0
        cnt_max = 0
        left = 0

        for right in range(n):
            if nums[right] == max_val:
                cnt_max += 1
            
            while cnt_max >= k:
                if nums[left] == max_val:
                    cnt_max -= 1
                left += 1
            
            ans += left
            
        return ans
    