# Time:O(mn), Space:O(mn)

from typing import List

class Solution:
    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])

        prefix = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m):
            for j in range(n):
                prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] + grid[i][j]
        
        ans = 0
        for i in range(m):
            for j in range(n):
                if prefix[i + 1][j + 1] <= k:
                    ans += 1
        
        return ans

# Space:O(1)
class Solution:
    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0

        for i in range(m):
            for j in range(n):
                if i > 0:
                    grid[i][j] += grid[i - 1][j]
                if j > 0:
                    grid[i][j] += grid[i][j - 1]
                if i > 0 and j > 0:
                    grid[i][j] -= grid[i - 1][j - 1]
                
                if grid[i][j] <= k:
                    ans += 1
        
        return ans
    