# Time:O(m*n), Space:O(1)

from typing import List

class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        m, n = len(mat), len(mat[0])
        res = []

        for d in range(m + n - 1):
            tmp = []
            for i in range(max(0, d - n + 1), min(m, d + 1)):
                j = d - i
                tmp.append(mat[i][j])

            if d % 2 == 0:
                tmp.reverse()

            res.extend(tmp)

        return res
