# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        
        # sort by start
        intervals.sort(key=lambda x: x[0])

        res = []
        cur_start, cur_end = intervals[0]

        for start, end in intervals[1:]:
            # overlap
            if start <= cur_end:
                cur_end = max(cur_end, end)
            else:
                res.append([cur_start, cur_end])
                cur_start, cur_end = start, end
        
        res.append([cur_start, cur_end]) # last interval
        return res
