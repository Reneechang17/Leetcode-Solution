# Time:O(n*total), Space:O(total)

from typing import List

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # P: all pos number, N: all neg number
        # P - N = target
        # P + N = sum(nums)
        # P = (target+sum(nums)) // 2
        total = sum(nums)
        if abs(target) > total or (target + total) % 2 != 0:
            return 0
        
        pos = (target + total) // 2

        dp = [0] * (pos + 1)
        dp[0] = 1

        for num in nums:
            # ensure each num only use once
            for s in range(pos, num - 1, -1):
                dp[s] += dp[s - num]
        
        return dp[pos]
    