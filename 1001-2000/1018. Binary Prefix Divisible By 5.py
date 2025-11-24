# Easy
# Math
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/binary-prefix-divisible-by-5/

from typing import *

class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        res = []
        cur = 0

        for bit in nums:
            cur = (cur * 2 + bit) % 5
            res.append(cur == 0)
        
        return res
