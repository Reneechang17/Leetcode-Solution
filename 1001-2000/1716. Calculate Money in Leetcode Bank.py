# Easy
# Math
# Time:O(1), Space:O(1)
# https://leetcode.cn/problems/calculate-money-in-leetcode-bank/

class Solution:
    def totalMoney(self, n: int) -> int:
        full_weeks = n // 7
        extra_days = n % 7

        # k weeks' sum = 28 + 7 * (k-1)
        # -> full_weeks * 28 + 7 * full_weeks * (full_weeks - 1) / 2
        full_weeks_sum = full_weeks * 28 + 7 * full_weeks * (full_weeks - 1) // 2

        extra_sum = 0
        for i in range(1, extra_days + 1):
            extra_sum += full_weeks + i
        
        return full_weeks_sum + extra_sum
