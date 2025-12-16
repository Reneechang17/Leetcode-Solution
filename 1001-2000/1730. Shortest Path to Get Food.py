# Time:O(mn), Space:O(mn)

from typing import *
from collections import deque

class Solution:
    def getFood(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])

        start = None
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '*':
                    start = (i, j)
                    break
            if start:
                break # break the outer for loop if start exists

        que = deque([(start[0], start[1], 0)]) # row, col, step
        vis = {start}
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        while que:
            r, c, steps = que.popleft()
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc

                # check bounds
                if 0 <= nr < m and 0 <= nc < n and (nr, nc) not in vis:
                    cell = grid[nr][nc]
                    
                    if cell == '#': # found food
                        return steps + 1
                    
                    if cell == 'O':
                        vis.add((nr, nc))
                        que.append((nr, nc, steps + 1))
        return -1
    