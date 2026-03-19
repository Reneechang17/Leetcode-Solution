# Time:O(nlog(max(piles))), Space:O(1)

from typing import List

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)

        while left < right:
            mid = (left + right) // 2
            hours = 0

            for p in piles:
                # ceil(p / mid)
                hours += (p + mid - 1) // mid

            if hours <= h:
                right = mid
            else:
                left = mid + 1
        
        return left
    