# Time:O(nlogn), Space:O(n)

from typing import List

class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        timeline = [] # (start, is_start, value)
        for start, end, value in events:
            timeline.append((start, True, value))
            timeline.append((end + 1, False, value))
        timeline.sort()

        max_val = 0
        res = 0

        for time, is_start, value in timeline:
            if is_start:
                res = max(res, value + max_val)
            else:
                max_val = max(max_val, value)
        return res
    