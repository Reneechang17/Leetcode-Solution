# Time:O(n²), Space:O(n²)

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [row[:] for row in matrix]

        for i in range(1, n):
            for j in range(n):
                cand = [dp[i - 1][j]]
                if j > 0:
                    cand.append(dp[i - 1][j - 1])
                if j < n - 1:
                    cand.append(dp[i - 1][j + 1])
                
                dp[i][j] += min(cand)
        return min(dp[n - 1])

# Space optimization -> O(n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        prev = matrix[0][:]

        for i in range(1, n):
            cur = [0] * n

            for j in range(n):
                cand = [prev[j]]
                if j > 0:
                    cand.append(prev[j - 1])
                if j < n - 1:
                    cand.append(prev[j + 1])
                
                cur[j] = matrix[i][j] + min(cand)
            
            prev = cur
        
        return min(prev)
    