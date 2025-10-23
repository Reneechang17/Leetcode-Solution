# Easy
# Simulation
# Time:O(n^2), Space:O(n)
# https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-i/

class Solution:
    def hasSameDigits(self, s: str) -> bool:
        while len(s) > 2:
            new_str = ""

            for i in range(len(s) - 1):
                digit = (int(s[i]) + int(s[i + 1])) % 10
                new_str += str(digit)
            
            s = new_str

        return s[0] == s[1]
