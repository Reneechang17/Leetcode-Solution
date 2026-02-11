# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        res = []
        max_height = 0

        for i in range(len(heights) - 1, -1, -1):
            if heights[i] > max_height:
                res.append(i)
                max_height = heights[i]
        
        res.reverse()
        return res
    