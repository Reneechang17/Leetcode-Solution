# Medium
# Greedy
# Time:O(n), Space:O(1) 
# https://leetcode.cn/problems/minimum-time-to-make-rope-colorful/

from typing import *

# Greedy to keep the most expensive(max_time), and remove others.

class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        cost = 0
        i = 0

        while i < len(colors):
            if i + 1 < len(colors) and colors[i] == colors[i + 1]:
                j = i
                max_time = 0
                time_sum = 0

                while j < len(colors) and colors[j] == colors[i]:
                    max_time = max(max_time, neededTime[j])
                    time_sum += neededTime[j]
                    j += 1
                
                cost += time_sum - max_time
                i = j
            else:
                i += 1

        return cost
