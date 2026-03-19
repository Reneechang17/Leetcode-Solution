from typing import List

class Solution:
    def minAbsDiff(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        ans = [[0] * (n - k + 1) for _ in range(m - k + 1)]

        for i in range(m - k + 1):
            for j in range(n - k + 1):
                vals = []
                for x in range(i, i + k):
                    for y in range(j, j + k):
                        vals.append(grid[x][y])
                
                vals_set = sorted(set(vals))

                if len(vals_set) == 1:
                    ans[i][j] = 0
                else:
                    min_diff = float('inf')
                    for idx in range(1, len(vals_set)):
                        diff = vals_set[idx] - vals_set[idx - 1]
                        if diff < min_diff:
                            min_diff = diff
                    ans[i][j] = min_diff
        
        return ans
    