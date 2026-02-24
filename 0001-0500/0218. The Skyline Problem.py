# Time:O(nlogn), Space:O(n)

import heapq
from typing import List

class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        events = []
        for l, r, h in buildings:
            events.append((l, -h)) # left boundary
            events.append((r, h)) # right boundary
        
        events.sort()

        res = []
        heap = [0]
        rem = {}
        prev_height = 0

        for x, h in events:
            if h < 0: # left boundary
                heapq.heappush(heap, h) # store neg -> max heap
            else:
                rem[h] = rem.get(h, 0) + 1
            
            while heap and -heap[0] in rem and rem[-heap[0]] > 0:
                top = -heapq.heappop(heap)
                rem[top] -= 1
                if rem[top] == 0:
                    del rem[top]
            
            cur_height = -heap[0]
            if cur_height != prev_height:
                res.append([x, cur_height])
                prev_height = cur_height
        
        return res
    