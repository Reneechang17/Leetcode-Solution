# Medium
# Greedy
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/

class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        # left -> unmatch '('
        # right -> unmatch ')'
        left = right = 0

        for c in s:
            if c == '(':
                left += 1
            else:
                if left > 0:
                    left -= 1
                else:
                    right += 1
        
        return left + right
    