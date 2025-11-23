# Medium
# DP
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/greatest-sum-divisible-by-three/

from typing import *

class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        dp = [0, float('-inf'), float('-inf')]
        
        for num in nums:
            tmp = dp[:]

            for i in range(3):
                remainder = (i + num) % 3
                dp[remainder] = max(dp[remainder], tmp[i] + num)
        
        return dp[0]
    