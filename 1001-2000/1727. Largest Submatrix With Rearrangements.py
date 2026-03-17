# Time:O(mn logn)
# Space:O(n)

from typing import List

class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])

        for i in range(1, m):
            for j in range(n):
                if matrix[i][j] == 1:
                    # 累加当前以上的连续的1
                    matrix[i][j] += matrix[i-1][j]
        
        ans = 0
        for i in range(m):
            heights = matrix[i][:]
            heights.sort(reverse=True)

            for j in range(n):
                # j用来遍历排序后的columns
                # heights[j] -> height
                # j+1 -> width(前j+1列都可以用)
                area = heights[j] * (j + 1) 
                ans = max(ans, area)
        
        return ans
    