# Easy
# String, Greedy
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/

class Solution:
    def minOperations(self, s: str) -> int:
        change_0 = 0
        for i in range(len(s)):
            exp = '0' if i % 2 == 0 else '1'
            if s[i] != exp:
                change_0 += 1
        
        change_1 = len(s) - change_0
        return min(change_0, change_1)
    