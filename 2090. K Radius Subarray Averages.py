# Medium
# Sliding Window
# Time:O(n), Space:O(1) 
# https://leetcode.cn/problems/k-radius-subarray-averages/

from typing import *

class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res = [-1] * n
        window_size = 2 * k + 1

        if window_size > n:
            return res
        
        # init the first window sum
        window_sum = sum(nums[:window_size])
        res[k] = window_sum // window_size  # round down

        for i in range(k + 1, n - k):
            # remove left and add right
            window_sum -= nums[i - k - 1]
            window_sum += nums[i + k]
            res[i] = window_sum // window_size  # round down
        
        return res      
