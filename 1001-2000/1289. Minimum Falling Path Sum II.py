# Time:O(n²), Space:O(n)

from typing import List

class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        prev = grid[0][:]

        for i in range(1, n):
            first_min = second_min = float("inf")
            first_min_idx = -1

            for j in range(n):
                if prev[j] < first_min:
                    second_min = first_min
                    first_min = prev[j]
                    first_min_idx = j
                elif prev[j] < second_min:
                    second_min = prev[j]

            cur = [0] * n
            for j in range(n):
                if j == first_min_idx:
                    cur[j] = grid[i][j] + second_min
                else:
                    cur[j] = grid[i][j] + first_min

            prev = cur

        return min(prev)
