# Time:O(rows*cols), Space:O(rows*cols)

from typing import List

class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        res = [[rStart, cStart]]

        if rows * cols == 1:
            return res
        
        step = 1
        d = 0

        while len(res) < rows * cols:
            for _ in range(2):
                for _ in range(step):
                    rStart += dirs[d][0]
                    cStart += dirs[d][1]
                    if 0 <= rStart < rows and 0 <= cStart < cols:
                        res.append([rStart, cStart])
                        if len(res) == rows * cols:
                            return res
                d = (d + 1) % 4
        
            step += 1
            