# Time:O(nlogn), Space:O(n)

from typing import List
import heapq

class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()

        idle = list(range(n))
        busy = []
        count = [0] * n

        for start, end in meetings:
            while busy and busy[0][0] <= start:
                _, room = heapq.heappop(busy)
                heapq.heappush(idle, room)
            
            if idle:
                room = heapq.heappop(idle)
                count[room] += 1
                heapq.heappush(busy, (end, room))
            else:
                end_time, room = heapq.heappop(busy)
                count[room] += 1
                heapq.heappush(busy, (end_time + (end - start), room))
                
        return count.index(max(count))
    