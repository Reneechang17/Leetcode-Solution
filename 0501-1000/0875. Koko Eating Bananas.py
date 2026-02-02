# Time:O(nlogM), Space:O(1)

from typing import List

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # binary search the speed of eating bananas
        # range is 1(slowest) to max(piles)(fastest)
        left, right = 1, max(piles)

        def can_finish(k):
            # check if speed k can finish in h hours
            hours = 0
            for p in piles:
                # ceil(p / k) -> (p + k - 1) // k
                hours += (p + k - 1) // k
                if hours > h:
                    return False
            return hours <= h

        while left < right:
            mid = (left + right) // 2
            if can_finish(mid):
                right = mid # mid can finish, find the less time
            else:
                left = mid + 1

        return left
    