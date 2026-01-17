# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        # sort by costA-costB (A cost less than B -> let them to A)
        costs.sort(key=lambda x: x[0] - x[1])

        n = len(costs) // 2
        total = 0
        for i in range(n):
            total += costs[i][0]  # first n to A
            total += costs[i + n][1]

        return total
    