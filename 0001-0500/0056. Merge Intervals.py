# Medium
# Array
# Time:O(nlogn), Space:O(n)
# https://leetcode.cn/problems/merge-intervals/

from typing import *

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        
        # sort by start
        intervals.sort(key=lambda x:x[0])

        res = [intervals[0]]

        for i in range(1, len(intervals)):
            cur = intervals[i]
            prev = res[-1]

            if cur[0] <= prev[1]:
                # merge
                prev[1] = max(prev[1], cur[1])
            else:
                res.append(cur)
        
        return res
