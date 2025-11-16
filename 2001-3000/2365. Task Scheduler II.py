# Medium
# Hash Table, Simulation
# Time:O(n), Space:O(k)
# https://leetcode.cn/problems/task-scheduler-ii/

from typing import *

class Solution:
    def taskSchedulerII(self, tasks: List[int], space: int) -> int:
        last_day = {} # task, last day
        day = 0

        for task in tasks:
            day += 1

            if task in last_day:
                time = last_day[task] + space + 1
                if day < time:
                    day = time
            last_day[task] = day
        
        return day
    