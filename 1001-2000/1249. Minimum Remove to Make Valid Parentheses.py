# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        remove = set()
        stack = [] # store '(' idx

        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == ')':
                if stack:
                    stack.pop() # match a '('
                else:
                    remove.add(i) # additional ')'
        
        for i in stack:
            remove.add(i)

        res = []
        for i, c in enumerate(s):
            if i not in remove:
                res.append(s[i])
                
        return res
