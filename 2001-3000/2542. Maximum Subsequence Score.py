# Time:O(nlogn), Space:O(n)

import heapq
from typing import List

class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        n = len(nums1)
        pairs = [(nums2[i], nums1[i]) for i in range(n)]
        pairs.sort(reverse=True)

        min_heap = []
        sum1 = 0
        ans = 0

        for i in range(n):
            n2, n1 = pairs[i]
            heapq.heappush(min_heap, n1)
            sum1 += n1

            if len(min_heap) > k:
                sum1 -= heapq.heappop(min_heap)

            if len(min_heap) == k:
                ans = max(ans, sum1 * n2)

        return ans
    