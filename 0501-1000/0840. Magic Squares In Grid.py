# Time:O(m*n), Space:O(1)

from typing import List

class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:

        def is_magic(r, c):
            vals = []
            for i in range(r, r + 3):
                for j in range(c, c + 3):
                    vals.append(grid[i][j])
            
            if sorted(vals) != list(range(1, 10)):
                return False
            
            # sum should be 15
            for i in range(3):
                if sum(grid[r + i][c : c + 3]) != 15:
                    return False
            
            for j in range(3):
                if sum(grid[r + i][c + j] for i in range(3)) != 15:
                    return False

            if grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != 15:
                return False
            
            if grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != 15:
                return False
            
            return True

        rows, cols = len(grid), len(grid[0])
        count = 0

        for r in range(rows - 2):
            for c in range(cols - 2):
                if is_magic(r, c):
                    count += 1
        
        return count
    