# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        remove = set()
        stack = []

        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            elif s[i] == ")":
                if stack:
                    stack.pop()
                else:
                    remove.add(i)

        for i in stack:
            remove.add(i)

        res = []
        for i in range(len(s)):
            if i not in remove:
                res.append(s[i])

        return "".join(res)
