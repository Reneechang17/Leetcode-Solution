# Medium
# Two Pointers
# Time:O(n^2), Space:O(1)
# https://leetcode.cn/problems/longest-palindromic-substring/

class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        
        def expand(left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1:right]
        
        res = ""
        for i in range(len(s)):
            odd = expand(i, i)
            even = expand(i, i + 1) # two chars in center
            res = max(res, odd, even, key=len)
        
        return res
    