# Time:O(nlogn), Space:O(1)
from typing import List

class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        # sort by costA - costB
        costs.sort(key=lambda x: x[0] - x[1])
        n = len(costs) // 2
        total = 0

        # first n -> city A
        for i in range(n):
            total += costs[i][0]

        # last n -> city B
        for i in range(n, 2 * n):
            total += costs[i][1]
        
        return total
    