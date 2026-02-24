# Time:O(mn), Space:O(mn)

from typing import List

class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0

        m, n = len(matrix), len(matrix[0])
        memo = [[0] * n for _ in range(m)]
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]

        def dfs(i, j):
            if memo[i][j] != 0:
                return memo[i][j]
            
            max_len = 1
            for dx, dy in dirs:
                x, y = i + dx, j + dy
                if 0 <= x < m and 0 <= y < n and matrix[x][y] > matrix[i][j]:
                    max_len = max(max_len, 1 + dfs(x, y))
            
            memo[i][j] = max_len
            return max_len

        ans = 0
        for i in range(m):
            for j in range(n):
                ans = max(ans, dfs(i, j))
        
        return ans
    