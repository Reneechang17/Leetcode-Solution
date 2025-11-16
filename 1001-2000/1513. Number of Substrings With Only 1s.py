# Medium
# Math
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/number-of-substrings-with-only-1s/

# for consecutive ones, there are (n * (n + 1)) // 2 substrings

class Solution:
    def numSub(self, s: str) -> int:
        MOD = 10**9 + 7
        res = 0
        cnt = 0

        for c in s:
            if c == '1':
                cnt += 1
            else:
                res += cnt * (cnt + 1) // 2
                cnt = 0
        res += cnt * (cnt + 1) // 2 # last seg

        return res % MOD
    