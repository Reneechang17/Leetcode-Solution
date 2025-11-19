# Hard
# Sliding Window
# Time:O(n*log(max_num)), Space:O(n)
# https://leetcode.cn/problems/maximum-frequency-score-of-a-subarray/

from typing import *

class Solution:
    def maxFrequencyScore(self, nums: List[int], k: int) -> int:
        from collections import defaultdict

        MOD = 10**9 + 7
        count = defaultdict(int)
        score = 0
        max_score = 0

        for i in range(len(nums)):
            num = nums[i]

            if count[num] > 0:
                score = (score - pow(num, count[num], MOD) + MOD) % MOD
            
            count[num] += 1
            score = (score + pow(num, count[num], MOD)) % MOD

            if i >= k:
                left_num = nums[i - k]
                score = (score - pow(left_num, count[left_num], MOD) + MOD) % MOD
                count[left_num] -= 1

                if count[left_num] > 0:
                    score = (score + pow(left_num, count[left_num], MOD)) % MOD

            if i >= k - 1:
                max_score = max(max_score, score)
        
        return max_score
