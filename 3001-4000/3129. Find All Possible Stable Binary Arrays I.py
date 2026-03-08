# Time:O(zero*one*limit)
# Space:O(zero*one)

class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        MOD = 10**9 + 7
        dp = [[[0,0] for _ in range(one + 1)] for _ in range(zero + 1)]

        for i in range(zero + 1):
            for j in range(one + 1):
                if i == 0 and j == 0:
                    dp[i][j][0] = dp[i][j][1] = 1
                    continue
                
                # end with zero
                for t in range(1, min(limit, i) + 1):
                    dp[i][j][0] = (dp[i][j][0] + dp[i-t][j][1]) % MOD
                
                # end with one
                for t in range(1, min(limit, j) + 1):
                    dp[i][j][1] = (dp[i][j][1] + dp[i][j-t][0]) % MOD
        
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD
    