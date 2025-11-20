# Hard
# Greedy, Interval
# Time:O(nlogn), Space:O(1)
# https://leetcode.cn/problems/set-intersection-size-at-least-two/

from typing import *

class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        # sort by end time, if same then dsc by start time
        intervals.sort(key=lambda x: (x[1], -x[0]))

        res = 0
        p1 = p2 = -1

        for start, end in intervals:
            # case 1: already incl 2, skip
            if start <= p1:
                continue

            # case 2: incl 1 (p2), need one more
            if start <= p2:
                p1 = p2
                p2 = end
                res += 1
            
            # need 2(select last two -> greedy for match later intervals)
            else:
                p1 = end - 1
                p2 = end 
                res += 2

        return res
    