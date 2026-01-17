# Time:O(n*m), Space:O(gaps)

from typing import List
from collections import defaultdict

class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        gap_count = defaultdict(int)

        for row in wall:
            width_sum = 0
            for brick in row[:-1]:
                width_sum += brick
                gap_count[width_sum] += 1

        max_gap = max(gap_count.values()) if gap_count else 0

        return len(wall) - max_gap
