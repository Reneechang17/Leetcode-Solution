# Time:O(logn), Space:O(1)

class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD = 10**9 + 7
        even = (n + 1) // 2
        odd = n // 2

        def pow(base, exp):
            res = 1
            while exp:
                if exp & 1:
                    res = (res * base) % MOD
                base = (base * base) % MOD
                exp >>= 1
            return res

        return (pow(5, even) * pow(4, odd)) % MOD
    