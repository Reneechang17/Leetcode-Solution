# Time:O(m*n), Space:O(n)

from typing import List

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0

        m, n = len(matrix), len(matrix[0])

        heights = [0] * n
        max_area = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    heights[j] += 1
                else:
                    heights[j] = 0

            max_area = max(max_area, self.largest_area(heights))
        
        return max_area
    
    def largest_area(self, heights):
        stack = []
        max_area = 0

        heights = [0] + heights + [0]

        for i in range(len(heights)):
            while stack and heights[stack[-1]] > heights[i]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1

                max_area = max(max_area, h * w)
                
            stack.append(i)
        
        return max_area
    