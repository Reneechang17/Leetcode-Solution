# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/removing-stars-from-a-string/

from typing import *

class Solution:
    def removeStars(self, s: str) -> str:
        stack = []

        for c in s:
            if c == '*':
                if stack:
                    stack.pop()
            else:
                stack.append(c)

        return ''.join(stack)
