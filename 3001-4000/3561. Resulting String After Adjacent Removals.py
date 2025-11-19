# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/resulting-string-after-adjacent-removals/

# diff could be 1 or 25('a' and 'z') 

class Solution:
    def resultingString(self, s: str) -> str:
        stack = []

        for c in s:
            if stack:
                diff = abs(ord(c) - ord(stack[-1]))
                if diff == 1 or diff == 25:
                    stack.pop()
                    continue
            stack.append(c)

        return ''.join(stack)
    