# Medium
# Segment trew
# Time:O(n logn), Space:O(n)
# https://leetcode.cn/problems/count-subarrays-with-more-ones-than-zeros/

from typing import *

class BIT:

    def __init__(self, n):
        self.n = n
        self.tree = [0] * (n + 1)

    def update(self, i, delta=1):
        while i <= self.n:
            self.tree[i] += delta
            i += i & (-i)
    
    def query(self, i):
        res = 0
        while i > 0:
            res += self.tree[i]
            i -= i & (-i)
        
        return res 

class Solution:
    def subarraysWithMoreOnesThanZeroes(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)

        offset = n + 1
        bit = BIT(2 * n + 2)

        prefix = 0
        bit.update(prefix + offset)
        res = 0

        for x in nums:
            prefix += 1 if x == 1 else -1

            res = (res + bit.query(prefix + offset - 1)) % MOD

            bit.update(prefix + offset)

        return res
