# Time:O(mn), Space:O(n) -> 1D DP

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n = len(t)
        dp = [0] * (n + 1)
        dp[0] = 1

        # dp[j] tracks ways to build t[:j] while scanning s
        for c in s:
            for j in range(n - 1, -1, -1):
                # this char can forming t[j]
                if c == t[j]:
                    # plus c, can forming t[:j + 1]
                    dp[j + 1] = dp[j] # <- prev solution that could form t[:j]
        
        return dp[n]
    