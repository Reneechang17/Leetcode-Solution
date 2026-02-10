# Time:O(n logk), Space:O(k)

import heapq
from typing import List

class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        min_heap = []

        for num in nums:
            x = int(num)

            heapq.heappush(min_heap, x)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        return str(min_heap[0])
    