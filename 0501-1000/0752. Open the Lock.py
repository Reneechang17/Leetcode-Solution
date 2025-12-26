# Time:O(1), Space:O(1)

from typing import List
from collections import deque

class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        dead = set(deadends)
        if "0000" in dead:
            return -1
        if target == "0000":
            return 0
        
        que = deque([("0000", 0)])
        vis = {"0000"}

        while que:
            cur, steps = que.popleft()

            for i in range(4):
                for delta in [-1, 1]:
                    new_digit = (int(cur[i]) + delta) % 10
                    neighbor = cur[:i] + str(new_digit) + cur[i + 1:]

                    if neighbor == target:
                        return steps + 1
                    
                    if neighbor not in vis and neighbor not in dead:
                        vis.add(neighbor)
                        que.append((neighbor, steps + 1))
        return -1
    