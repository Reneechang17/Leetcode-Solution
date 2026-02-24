# Time:O(nlogn), Space:O(n)

import heapq
from typing import List

class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        events.sort()
        n = len(events)
        
        pq = []
        i = 0
        day = 1
        ans = 0

        while i < n or pq:
            while i < n and events[i][0] == day:
                heapq.heappush(pq, events[i][1])
                i += 1
            
            while pq and pq[0] < day:
                heapq.heappop(pq)
            
            if pq:
                heapq.heappop(pq)
                ans += 1
            day += 1
        
        return ans
    