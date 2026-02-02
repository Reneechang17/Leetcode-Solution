# Time:O(nlogn), Space:O(n)

import heapq
from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0

        # sort by start time
        intervals.sort(key=lambda x: x[0])

        heap = [] # store cur end time 

        for start, end in intervals:
            # prev' meeting end -> use it
            if heap and start >= heap[0]:
                heapq.heappop(heap)
            
            # need new one
            heapq.heappush(heap, end)
        
        return len(heap)
    