from typing import List

class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:

        def can_finish(t):
            total = 0
            for wt in workerTimes:
                left, right = 1, mountainHeight
                while left <= right:
                    mid = (left + right) // 2
                    if wt * mid * (mid + 1) // 2 <= t:
                        left = mid + 1
                    else:
                        right = mid - 1
                total += right
                if total >= mountainHeight:
                    return True
            return total >= mountainHeight

        lo, hi = 1, max(workerTimes) * mountainHeight * (mountainHeight + 1) // 2
        while lo < hi:
            mid = (lo + hi) // 2
            if can_finish(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
    