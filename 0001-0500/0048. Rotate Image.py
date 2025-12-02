# Medium
# Matrix, Array
# Time:O(n^2), Space:O(1)
# https://leetcode.cn/problems/rotate-image/

from typing import *

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        for i in range(n):
            matrix[i].reverse()
