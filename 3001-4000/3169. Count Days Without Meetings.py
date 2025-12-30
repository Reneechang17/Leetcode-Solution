# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort()

        busy = 0
        prev_end = 0

        for start, end in meetings:
            if start > prev_end:
                busy += end - start + 1
            else:
                busy += max(0, end - prev_end)
            
            prev_end = max(prev_end, end)
        
        return days - busy
    