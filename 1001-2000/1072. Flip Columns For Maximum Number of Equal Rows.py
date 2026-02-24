# Time:O(mn), Space:O(mn)

from typing import Counter, List

class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        count = Counter()

        for row in matrix:
            if row[0] == 0:
                count[str(row)] += 1
            else:
                flipped = [1 - x for x in row]
                count[str(flipped)] += 1
        
        return max(count.values())
    