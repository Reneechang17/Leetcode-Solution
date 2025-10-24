# Medium
# Prefix
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/maximum-good-subarray-sum/

from typing import *

class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        # minimum prefix sum before x
        prefix = {}

        prefix_sum = 0
        max_sum = float('-inf')
        
        for num in nums:
            prefix_sum += num

            # check if num - k or num + k appears
            if num - k in prefix:
                sub_sum = prefix_sum - prefix[num - k]
                max_sum = max(max_sum, sub_sum)
            
            if num + k in prefix:
                sub_sum = prefix_sum - prefix[num + k]
                max_sum = max(max_sum, sub_sum)

            if num not in prefix:
                prefix[num] = prefix_sum - num # not incl current 
            else:
                prefix[num] = min(prefix[num], prefix_sum - num)
        
        return max_sum if max_sum != float('-inf') else 0  
