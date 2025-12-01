# Easy
# String
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/is-subsequence/

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i = 0 # go through s
        for c in t:
            if i < len(s) and c == s[i]:
                i += 1

        return i == len(s)
    