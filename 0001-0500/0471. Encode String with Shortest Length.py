# Time:O(n⁴), Space:O(n²)

class Solution:
    def encode(self, s: str) -> str:
        n = len(s)
        dp = [[""] * n for _ in range(n)]

        for length in range(1, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                substr = s[i : j + 1]
                dp[i][j] = substr

                if length <= 4:
                    continue

                for k in range(1, length):
                    if length % k == 0:
                        pattern = substr[:k]
                        if pattern * (length // k) == substr:
                            encoded = str(length // k) + "[" + dp[i][i + k - 1] + "]"
                            if len(encoded) < len(dp[i][j]):
                                dp[i][j] = encoded

                for k in range(i, j):
                    candidate = dp[i][k] + dp[k + 1][j]
                    if len(candidate) < len(dp[i][j]):
                        dp[i][j] = candidate

        return dp[0][n - 1]
