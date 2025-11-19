# Medium
# Greedy
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/minimum-operations-to-make-the-array-alternating/

from typing import *

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        from collections import Counter

        n = len(nums)
        if n == 1:
            return 0
        
        even_freq = Counter(nums[i] for i in range(0, n, 2))
        odd_freq = Counter(nums[i] for i in range(1, n, 2))

        # (val, freq)
        even_t2 = even_freq.most_common(2)
        odd_t2 = odd_freq.most_common(2)

        if len(even_t2) == 1:
            even_t2.append((0,0))
        if len(odd_t2) == 1:
            odd_t2.append((0,0))

        if even_t2[0][0] != odd_t2[0][0]:
            return n - even_t2[0][1] - odd_t2[0][1]
        
        option1 = n - even_t2[0][1] - odd_t2[1][1]
        option2 = n - even_t2[1][1] - odd_t2[0][1]

        return min(option1, option2)
