# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        cnt = {}
        n = len(nums)
        left = 0
        ans = 0

        for right in range(n):
            cnt[nums[right]] = cnt.get(nums[right], 0) + 1

            while cnt[nums[right]] > k:
                cnt[nums[left]] -= 1
                left += 1
            
            ans = max(ans, right - left + 1)
        
        return ans
    