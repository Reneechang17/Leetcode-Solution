# Time:O(nlog (min(time) * totalTrip))
# Space:O(1)

from typing import List

class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        left = 1
        right = min(time) * totalTrips

        while left < right:
            mid = (left + right) // 2

            trips = 0
            for t in time:
                trips += mid // t
            
            if trips >= totalTrips:
                right = mid
            else:
                left = mid + 1
        
        return left
    