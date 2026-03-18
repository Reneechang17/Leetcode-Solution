# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        n = len(nums)
        zeros = 0
        max_len = 0
        left = 0

        for right in range(n):
            if nums[right] == 0:
                zeros += 1
            
            while zeros > k:
                if nums[left] == 0:
                    zeros -= 1
                left += 1
            
            max_len = max(max_len, right - left + 1)
        
        return max_len
