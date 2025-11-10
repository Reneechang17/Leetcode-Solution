# Medium
# Stack 
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero/

from typing import *

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        s = []
        res = 0

        for x in nums:
            while s and s[-1] > x:
                s.pop()
            if x == 0:
                continue
            if not s or s[-1] < x:
                res += 1
                s.append(x)
                
        return res
    