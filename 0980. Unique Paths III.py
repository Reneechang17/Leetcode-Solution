
from typing import *

class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        empty = 0
        start_row, start_col = -1, -1

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 0:
                    empty += 1
                elif grid[i][j] == 1:
                    start_row, start_col = i, j
                elif grid[i][j] == 2:
                    empty += 1
        empty += 1

        self.path = 0

        def backtracking(row, col, vis):
            if grid[row][col] == 2:
                if vis == empty:
                    self.path += 1
                return
            
            tmp = grid[row][col]
            grid[row][col] = -2

            for dr, dc in [(-1,0),(0,1),(1,0),(0,-1)]:
                new_row, new_col = row + dr, col + dc
                
                if (0 <= new_row < rows and 0 <= new_col < cols 
                    and (grid[new_row][new_col] == 0 or grid[new_row][new_col] == 2)):
                    backtracking(new_row, new_col, vis + 1)
            
            # 回溯
            grid[row][col] = tmp
        
        backtracking(start_row, start_col, 1)
        return self.path
    