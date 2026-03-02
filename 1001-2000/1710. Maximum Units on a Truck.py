# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda x: -x[1])

        ans = 0
        for boxes, units in boxTypes:
            take = min(boxes, truckSize)
            ans += take * units
            truckSize -= take
            if truckSize == 0:
                break
        
        return ans
    