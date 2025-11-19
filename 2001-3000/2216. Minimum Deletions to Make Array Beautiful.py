# Medium
# 
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/

from typing import *

class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        ops = 0
        i = 0

        while i < len(nums):
            j = i + 1
            while j < len(nums) and nums[j] == nums[i]:
                ops += 1
                j += 1
            
            i = j + 1

        remain = len(nums) - ops
        if remain % 2 == 1:
            ops += 1
        
        return ops
