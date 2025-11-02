# Easy
# Set
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/the-two-sneaky-numbers-of-digitville/

from typing import *

class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        vis = set()
        res = []

        for num in nums:
            if num in vis:
                res.append(num)
            else:
                vis.add(num)
        return res
    