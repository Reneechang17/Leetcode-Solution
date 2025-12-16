# Time:O(n), Space:O(1)

from typing import *

class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        min_dist = float('inf')

        for i in range(n):
            if words[i] == target:
                clockwise = abs(i - startIndex)
                counterclockwise = n - clockwise

                min_dist = min(min_dist, clockwise, counterclockwise)
        
        return -1 if min_dist == float('inf') else min_dist
    