# Easy
# String
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/remove-outermost-parentheses/

class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        res = []
        depth = 0

        for c in s:
            if c == '(':
                if depth > 0:
                    res.append(c)
                depth += 1
            else:
                depth -= 1
                if depth > 0:
                    res.append(c)
        
        return ''.join(res)
    