
from typing import *

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)

        if grid[0][0] == 1 or grid[n - 1][n - 1] == 1:
            return -1
        
        if n == 1:
            return 1
        
        dirs = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]

        from collections import deque
        que = deque([(0,0,1)]) # (x, y, steps)
        grid[0][0] = 1

        while que:
            x, y, steps = que.popleft()

            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                
                if nx == n - 1 and ny == n - 1:
                    return steps + 1
                
                if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 0:
                    que.append((nx, ny, steps + 1))
                    grid[nx][ny] = 1
        
        return -1
    