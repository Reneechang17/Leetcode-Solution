# Easy
# Array
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/check-if-all-1s-are-at-least-length-k-places-away/

from typing import *

class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        prev = -1
        for i in range(len(nums)):
            if nums[i] == 1:
                if prev != -1 and i - prev - 1 < k:
                    return False
                prev = i
                
        return True
    