# Time:O(nlogn), Space:O(n)

import heapq
from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return True
        
        intervals.sort(key=lambda x:x[0])

        heap = []

        for start, end in intervals:
            # if the earliest meeting end -> release
            if heap and heap[0] <= start:
                heapq.heappop(heap)
            
            # or means need one more room
            heapq.heappush(heap, end)
        
        return len(heap)
    