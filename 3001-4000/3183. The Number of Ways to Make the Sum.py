# Time:O(n), Space:O(n)

class Solution:
    def numberOfWays(self, n: int) -> int:
        MOD = 10**9 + 7

        # use unlimited 1,2,6
        dp = [0] * (n + 1)
        dp[0] = 1

        for coin in [1, 2, 6]:
            for i in range(coin, n + 1):
                dp[i] = (dp[i] + dp[i - coin]) % MOD
        
        total = dp[n]

        # use 1 coin 4
        if n >= 4:
            total = (total + dp[n - 4]) % MOD
        
        # use 2 coin 4
        if n >= 8:
            total = (total + dp[n - 8]) % MOD
        
        return total
    