# Time:O(m), Space:O(m)

from typing import List
from collections import defaultdict

class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        reserved = defaultdict(set)
        for row, seat in reservedSeats:
            reserved[row].add(seat)
        
        count = 0

        for row, seats in reserved.items():
            left = all(s not in seats for s in [2, 3, 4, 5])
            mid = all(s not in seats for s in [4, 5, 6, 7])
            right = all(s not in seats for s in [6, 7, 8, 9])

            if left and right:
                count += 2 # can sit both side
            elif left or mid or right:
                count += 1 # can sit one group
        count += 2 * (n - len(reserved))

        return count
    