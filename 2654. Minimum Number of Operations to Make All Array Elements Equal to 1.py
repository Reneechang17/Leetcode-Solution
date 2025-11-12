# Medium
# Math
# Time:O(n² log M), Space:O(1)
# https://leetcode.cn/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/

from typing import *

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        from math import gcd
        n = len(nums)

        one = nums.count(1)
        if one > 0:
            return n - one
        
        min_len = float('inf')

        for i in range(n):
            g = nums[i]
            for j in range(i, n):
                g = gcd(g, nums[j])

                if g == 1:
                    min_len = min(min_len, j - i)
                    break
        
        if min_len == float('inf'):
            return -1
        
        return min_len + n - 1
    