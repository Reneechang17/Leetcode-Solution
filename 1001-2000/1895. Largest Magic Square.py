# Time:O(n³), Space:O(mn)

# bruce force to check and optimize with prefix sum to precompute...?

from typing import List

class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row_sum = [[0] * (n + 1) for _ in range(m)]
        for i in range(m):
            for j in range(n):
                row_sum[i][j + 1] = row_sum[i][j] + grid[i][j]

        col_sum = [[0] * (m + 1) for _ in range(n)]
        for j in range(n):
            for i in range(m):
                col_sum[j][i + 1] = col_sum[j][i] + grid[i][j]

        def get_row_sum(r, c1, c2):
            return row_sum[r][c2 + 1] - row_sum[r][c1]

        def get_col_sum(c, r1, r2):
            return col_sum[c][r2 + 1] - col_sum[c][r1]

        ans = 0
        for r in range(m):
            for c in range(n):
                max_k = min(m - r, n - c)
                for k in range(max_k, ans, -1):
                    target = get_row_sum(r, c, c + k - 1)
                    flag = True

                    for i in range(r, r + k):
                        if get_row_sum(i, c, c + k - 1) != target:
                            flag = False
                            break
                    if not flag:
                        continue

                    for j in range(c, c + k):
                        if get_col_sum(j, r, r + k - 1) != target:
                            flag = False
                            break
                    if not flag:
                        continue

                    diag1 = 0
                    for d in range(k):
                        diag1 += grid[r + d][c + d]
                    if diag1 != target:
                        continue

                    diag2 = 0
                    for d in range(k):
                        diag2 += grid[r + d][c + k - 1 - d]
                    if diag2 != target:
                        continue

                    ans = max(ans, k)
                    break
        return ans
    