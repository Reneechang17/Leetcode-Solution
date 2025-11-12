# Easy
# Math
# Time:O(1), Space:O(1)
# https://leetcode.cn/problems/minimum-operations-to-collect-elements/

from typing import List

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        need = set(range(1, k + 1))
        ops = 0

        # Go through from end of arr
        # range(start, stop, step)
        for i in range(len(nums) - 1, -1, -1):
            ops += 1
            
            if nums[i] in need:
                need.remove(nums[i])

            if not need:
                return ops
            
        return ops
