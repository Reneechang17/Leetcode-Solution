# Easy
# Stack
# Time:O(m+n), Space:O(m+n)
# https://leetcode.cn/problems/backspace-string-compare/

class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        # Use helper func
        def helper(string):
            stack = []
            for c in string:
                if c != '#':
                    stack.append(c)
                elif stack:
                    stack.pop()
            return ''.join(stack)
        
        return helper(s) == helper(t)
        