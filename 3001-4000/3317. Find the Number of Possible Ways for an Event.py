# Time:O(n² + x²), Space:O(n² + x²)

class Solution:
    def numberOfWays(self, n: int, x: int, y: int) -> int:
        MOD = 10**9 + 7
        C = [[0] * (x + 1) for _ in range(x + 1)]
        for i in range(x + 1):
            C[i][0] = C[i][i] = 1
            for j in range(1, i):
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD

        S = [[0] * (n + 1) for _ in range(n + 1)]
        S[0][0] = 1
        for i in range(1, n + 1):
            for j in range(1, i + 1):
                S[i][j] = (S[i - 1][j - 1] + j * S[i - 1][j]) % MOD
        
        ans = 0
        for k in range(1, min(n, x) + 1):
            ways = C[x][k] * fact[k] % MOD
            ways = ways * S[n][k] % MOD
            ways = ways * pow(y, k, MOD) % MOD
            ans = (ans + ways) % MOD
        
        return ans
    