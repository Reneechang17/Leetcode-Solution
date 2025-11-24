# Medium
# Stack
# Time:O(n^2), Space:O(n)
# https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/

class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = []
        cur = []

        for c in s:
            if c == '(':
                stack.append(cur)
                cur = []
            elif c == ')':
                # reverse cur level
                cur = stack.pop() + cur[::-1]
            else:
                cur.append(c)
        
        return ''.join(cur)
    