import heapq
from typing import List

# heap - Time:O(nk logn), Space:O(n+k)
class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        heap = [1]
        vis = {1}
        val = 1

        for _ in range(n):
            val = heapq.heappop(heap)
            for p in primes:
                next = val * p
                if next not in vis:
                    vis.add(next)
                    heapq.heappush(heap, next)
        
        return val
    