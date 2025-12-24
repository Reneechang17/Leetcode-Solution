# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        def can_share(per_child):
            count = sum(c // per_child for c in candies)
            return count >= k
        
        left, right = 1, max(candies)
        ans = 0

        while left <= right:
            mid = (left + right) // 2
            if can_share(mid):
                ans = mid
                left = mid + 1
            else:
                right = mid - 1
        return ans
    