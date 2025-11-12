# Medium
# Prefix
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/

from typing import *

class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        prefix = {0: -1}

        prefix_sum = 0
        max_len = 0

        for i, num in enumerate(nums):
            prefix_sum += num
            target = prefix_sum - k

            if target in prefix:
                len = i - prefix[target]
                max_len = max(max_len, len)

            # only record the first appear index
            if prefix_sum not in prefix:
                prefix[prefix_sum] = i
        
        return max_len
