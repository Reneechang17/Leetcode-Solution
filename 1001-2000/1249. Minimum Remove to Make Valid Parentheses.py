# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        remove = set()
        stack = []

        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == ')':
                if stack:
                    stack.pop()
                else:
                    remove.add(i)

        remove.update(stack)

        return ''.join(s[i] for i in range(len(s)) if i not in remove)
