# Time:O(V*n), Space:O(1)

from typing import List

class Solution:
    def pourWater(self, heights: List[int], volume: int, k: int) -> List[int]:
        for _ in range(volume):
            best = k
            for i in range(k - 1, -1, -1):
                if heights[i] > heights[best]:
                    break
                if heights[i] < heights[best]:
                    best = i
        
            if best != k:
                heights[best] += 1
                continue
        
            for i in range(k + 1, len(heights)):
                if heights[i] > heights[best]:
                    break
                if heights[i] < heights[best]:
                    best = i
        
            heights[best] += 1
    
        return heights
    