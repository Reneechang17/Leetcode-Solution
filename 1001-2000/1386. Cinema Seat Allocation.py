# Time:O(r), Space:O(r)

from typing import List
from collections import defaultdict

class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        reserved = defaultdict(set)
        for row, seat in reservedSeats:
            reserved[row].add(seat)

        count = 0

        for row, seats in reserved.items():
            left = True
            for s in [2, 3, 4, 5]:
                if s in seats:
                    left = False
                    break

            mid = True
            for s in [4, 5, 6, 7]:
                if s in seats:
                    mid = False
                    break

            right = True
            for s in [6, 7, 8, 9]:
                if s in seats:
                    right = False
                    break

            if left and right:
                count += 2
            elif left or mid or right:
                count += 1

        count += 2 * (n - len(reserved))
        return count
    