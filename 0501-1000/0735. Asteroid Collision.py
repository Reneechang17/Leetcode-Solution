# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/asteroid-collision/

from typing import *

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []

        for ast in asteroids:
            while stack and ast < 0 < stack[-1]:
                if stack[-1] < -ast:
                    stack.pop()
                    continue
                elif stack[-1] == -ast:
                    stack.pop()
                break # cur boom~
            else:
                stack.append(ast)

        return stack
    