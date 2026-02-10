from typing import List
import heapq

class KthLargest:

    # Time:O(nlogk), Space:O(k)
    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.min_heap = []

        for x in nums:
            self.add(x)

    # Time:O(logk), Space:O(k)
    def add(self, val: int) -> int:
        heapq.heappush(self.min_heap, val)

        if len(self.min_heap) > self.k:
            heapq.heappop(self.min_heap)
        
        return self.min_heap[0]
    