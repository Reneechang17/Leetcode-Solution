# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        n = len(energy)
        dp = energy[:]

        for i in range(n - k - 1, -1, -1):
            dp[i] = energy[i] + dp[i + k]
        
        return max(dp)
    