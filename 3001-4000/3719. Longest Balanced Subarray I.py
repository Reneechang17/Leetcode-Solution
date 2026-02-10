# Time:O(n²), Space:O(n)

# Brute force

from typing import List

class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        n = len(nums)
        max_len = 0

        for i in range(n):
            odd = set()
            even = set()

            for j in range(i, n):
                num = nums[j]
                val = num

                if val % 2 == 0:
                    even.add(val)
                else:
                    odd.add(val)
                
                if len(odd) == len(even):
                    max_len = max(max_len, j - i + 1)
        
        return max_len
    