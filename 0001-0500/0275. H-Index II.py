# Time:O(logn), Space:O(1)

from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left, right = 0, n - 1

        # find first satisfied citations[i] >= n - i
        while left <= right:
            mid = (left + right) // 2
            if citations[mid] >= n - mid:
                right = mid - 1
            else:
                left = mid + 1
        
        return n - left
    