# Medium
# Math
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/count-number-of-homogenous-substrings/

# Same: lc 1513

class Solution:
    def countHomogenous(self, s: str) -> int:
        MOD = 10**9 + 7
        res = 0
        cnt = 1

        # start from second char
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                cnt += 1
            else:
                res += cnt * (cnt + 1) // 2
                cnt = 1
    
        res += cnt * (cnt + 1) // 2 # last seg

        return res % MOD
