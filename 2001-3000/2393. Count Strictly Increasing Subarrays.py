# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        ans = 0
        i = 0
        n = len(nums)
        while i < n:
            j = i
            while j + 1 < n and nums[j + 1] > nums[j]:
                j += 1
            length = j - i + 1
            ans += length * (length + 1) // 2
            i = j + 1
        
        return ans
    