# Easy
# Sliding Window, Array
# Time:O(nlogn), Space:O(n)
# https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-i/

from collections import Counter
from typing import *

class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        res = []

        for i in range(len(nums) - k + 1):
            window = nums[i:i + k]
            freq = Counter(window)
            sorted_items = sorted(freq.items(), key=lambda p: (p[1], p[0]), reverse=True)

            x_sum = 0
            for num, cnt in sorted_items[:x]:
                x_sum += num * cnt
            
            res.append(x_sum)
        
        return res         
