# Time:O(n*m), Space:O(n*m)

from typing import List
from collections import defaultdict

class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        gap_count = defaultdict(int)

        for row in wall:
            pos = 0

            for i in range(len(row) - 1):
                pos += row[i]
                gap_count[pos] += 1
        
        max_gaps = max(gap_count.values()) if gap_count else 0
        return len(wall) - max_gaps
    