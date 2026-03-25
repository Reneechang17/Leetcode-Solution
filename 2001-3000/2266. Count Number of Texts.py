# Time:O(n), Space:O(n)

class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        MOD = 10**9 + 7
        n = len(pressedKeys)
        dp = [0] * (n + 1)
        dp[0] = 1

        for i in range(1, n + 1):
            ch = pressedKeys[i-1]
            dp[i] = dp[i-1]

            if i >= 2 and pressedKeys[i-2] == ch:
                dp[i] = (dp[i] + dp[i-2]) % MOD

                if i >= 3 and pressedKeys[i-3] == ch:
                    dp[i] = (dp[i] + dp[i-3]) % MOD

                    if (ch == '7' or ch == '9') and i >= 4 and pressedKeys[i-4] == ch:
                        dp[i] = (dp[i] + dp[i-4]) % MOD

        return dp[n]
    