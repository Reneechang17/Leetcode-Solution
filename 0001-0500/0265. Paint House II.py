# Time:O(n*k), Space:O(k)

from typing import List

class Solution:
    def minCostII(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0

        n = len(costs)
        k = len(costs[0])

        prev = costs[0][:]

        for i in range(1, n):
            min1 = min2 = float("inf")
            min1_idx = -1

            for j in range(k):
                if prev[j] < min1:
                    min2 = min1
                    min1 = prev[j]
                    min1_idx = j
                elif prev[j] < min2:
                    min2 = prev[j]

            cur = [0] * k
            for j in range(k):
                if j == min1_idx:
                    cur[j] = costs[i][j] + min2
                else:
                    cur[j] = costs[i][j] + min1

            prev = cur

        return min(prev)
    