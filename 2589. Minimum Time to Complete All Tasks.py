# Hard
# Greedy
# Time:O(n × max_time), Space:O(max_time)
# https://leetcode.cn/problems/minimum-time-to-complete-all-tasks/

from typing import *

class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        # sort by end time
        tasks.sort(key=lambda x:x[1])

        # True:1, False:0
        running = [False] * 2001 # time in [1, 2000]

        for start, end, dur in tasks:
            already = sum(running[start:end + 1])
            need = dur - already

            if need > 0:
                for t in range(end, start - 1, -1):
                    if not running[t]:
                        running[t] = True
                        need -= 1
                        if need == 0:
                            break

        return sum(running)
    