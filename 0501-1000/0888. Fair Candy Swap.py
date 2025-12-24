# Time:O(n+m), Space:O(m)

from typing import List

class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        sum_a, sum_b = sum(aliceSizes), sum(bobSizes)
        diff = (sum_a - sum_b) // 2

        bob_set = set(bobSizes)

        for x in aliceSizes:
            y = x - diff
            if y in bob_set:
                return [x, y]
            