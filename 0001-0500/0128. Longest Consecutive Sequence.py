# Medium
# Greedy
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/longest-consecutive-sequence/

# Use set to do linear search, but we need to make sure the start is correct
# for each "potential" start num, no num-1

from typing import *

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        num_set = set(nums) # O(n)
        max_len = 0

        for num in num_set:
            if num - 1 not in num_set:
                cur = num
                cur_len = 1

                while cur + 1 in num_set:
                    cur += 1
                    cur_len += 1
                
                max_len = max(max_len, cur_len)
        
        return max_len
