# Medium
# Greedy
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/maximum-subarray/

from typing import *

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = nums[0]
        cur_sum = nums[0]

        for i in range(1, len(nums)):
            cur_sum = max(cur_sum + nums[i], nums[i]) # plus cur / reset
            max_sum = max(max_sum, cur_sum)

        return max_sum
    