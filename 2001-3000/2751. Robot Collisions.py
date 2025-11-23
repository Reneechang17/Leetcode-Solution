# Hard
# Stack
# Time:O(nlogn), Space:O(n)
# https://leetcode.cn/problems/robot-collisions/

from typing import *

class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        n = len(positions)
        robots = [(positions[i], healths[i], directions[i], i) for i in range(n)]

        robots.sort(key=lambda x:x[0]) # sort by position

        stack = []

        for pos, health, dir, idx in robots:
            if dir == 'R':
                stack.append([health, dir, idx])
            else:
                while stack and stack[-1][1] == 'R' and health > 0:
                    top_health = stack[-1][0]

                    if top_health > health:
                        # stack top wins, cur boom
                        stack[-1][0] -= 1
                        health = 0
                    elif top_health < health:
                        # cur wins
                        stack.pop()
                        health -= 1
                    else:
                        stack.pop()
                        health = 0

                if health > 0:
                    stack.append([health, dir, idx])

        stack.sort(key=lambda x:x[2])
        return [robot[0] for robot in stack]
    