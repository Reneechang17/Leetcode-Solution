# Hard
# Queue
# Time:O(n), Space:O(n) 
# https://leetcode.cn/problems/time-taken-to-cross-the-door/

from typing import *
from collections import deque

class Solution:
    def timeTaken(self, arrival: List[int], state: List[int]) -> List[int]:
        n = len(arrival)
        res = [0] * n
        enter = deque()
        exit = deque()

        time = 0
        i = 0
        prev = 1 # exit first

        while i < n or enter or exit:
            while i < n and arrival[i] <= time:
                if state[i] == 0:
                    enter.append(i)
                else:
                    exit.append(i)
                i += 1
            
            if enter and exit:
                if prev == 1:
                    idx = exit.popleft()
                    prev = 1
                else:
                    idx = enter.popleft()
                    prev = 0
            elif exit:
                idx = exit.popleft()
                prev = 1
            elif enter:
                idx = enter.popleft()
                prev = 0
            else:
                time = arrival[i]
                prev = 1
                continue

            res[idx] = time
            time += 1
        
        return res
