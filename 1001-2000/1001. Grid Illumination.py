# Time:O(lamps + queries), Space:O(lamps)

from collections import defaultdict
from typing import List

class Solution:
    def gridIllumination(
        self, n: int, lamps: List[List[int]], queries: List[List[int]]
    ) -> List[int]:
        rows = defaultdict(int)
        cols = defaultdict(int)
        diag1 = defaultdict(int)
        diag2 = defaultdict(int)

        lamp_set = set()

        for r, c in lamps:
            if (r, c) in lamp_set:
                continue
            lamp_set.add((r, c))
            rows[r] += 1
            cols[c] += 1
            diag1[r - c] += 1
            diag2[r + c] += 1

        res = []

        for r, c in queries:
            if rows[r] > 0 or cols[c] > 0 or diag1[r - c] > 0 or diag2[r + c] > 0:
                res.append(1)
            else:
                res.append(0)

            for dr in [-1, 0, 1]:
                for dc in [-1, 0, 1]:
                    nr, nc = r + dr, c + dc
                    if (nr, nc) in lamp_set:
                        lamp_set.remove((nr, nc))
                        rows[nr] -= 1
                        cols[nc] -= 1
                        diag1[nr - nc] -= 1
                        diag2[nr + nc] -= 1

        return res
    