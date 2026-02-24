# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return 0
        
        left, right = n, 0
        max_seen = float('-inf')
        min_seen = float('inf')

        for i in range(n):
            max_seen = max(max_seen, nums[i])
            if nums[i] < max_seen:
                right = i
        
        for i in range(n - 1, -1, -1):
            min_seen = min(min_seen, nums[i])
            if nums[i] > min_seen:
                left = i
        
        return 0 if left >= right else right - left + 1
     