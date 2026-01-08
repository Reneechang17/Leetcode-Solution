# Time:O(target * n * avg_count), Space:O(target)

from typing import List

class Solution:
    def waysToReachTarget(self, target: int, types: List[List[int]]) -> int:
        MOD = 10**9 + 7
        dp = [0] * (target + 1)
        dp[0] = 1

        for count, mark in types:
            for score in range(target, -1, -1):
                # select t questions from cur type
                for t in range(1, count + 1):
                    if score + t * mark <= target:
                        dp[score + t * mark] = (dp[score + t * mark] + dp[score]) % MOD
        return dp[target]
