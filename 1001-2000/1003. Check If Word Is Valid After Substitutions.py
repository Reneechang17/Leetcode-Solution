# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            stack.append(c)
            if len(stack) >= 3:
                if stack[-3] == 'a' and stack[-2] == 'b' and stack[-1] == 'c':
                    stack[-3:] = []
        
        return len(stack) == 0 
    