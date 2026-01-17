# Time:O(m*n), Space:O(m*n)

from typing import List

class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])
        memo = {}

        def dfs(i, j):
            if (i, j) in memo:
                return memo[(i, j)]
            count = 1

            for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and grid[ni][nj] > grid[i][j]:
                    count = (count + dfs(ni, nj)) % MOD

            memo[(i, j)] = count
            return count

        res = 0
        for i in range(m):
            for j in range(n):
                res = (res + dfs(i, j)) % MOD

        return res
