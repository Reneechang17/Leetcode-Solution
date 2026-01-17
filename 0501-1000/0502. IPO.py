# Time:O(nlogn), Space:O(n)

import heapq
from typing import List

class Solution:
    def findMaximizedCapital(
        self, k: int, w: int, profits: List[int], capital: List[int]
    ) -> int:
        n = len(profits)
        projects = [(capital[i], profits[i]) for i in range(n)]
        projects.sort()

        available = []
        i = 0

        for _ in range(k):
            while i < n and projects[i][0] <= w:
                heapq.heappush(available, -projects[i][1])
                i += 1

            if not available:
                break

            w += -heapq.heappop(available)

        return w
    