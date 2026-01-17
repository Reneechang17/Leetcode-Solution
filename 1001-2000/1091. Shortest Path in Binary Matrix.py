# Time:O(n²), Space:O(n²)

from collections import deque
from typing import *

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if grid[0][0] == 1 or grid[n - 1][n - 1] == 1:
            return -1

        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1)]

        que = deque()
        que.append((0, 0))
        grid[0][0] = 1
        steps = 1

        while que:
            size = len(que)
            for i in range(size):
                x, y = que.popleft()
                if x == n - 1 and y == n - 1:
                    return steps
                for dx, dy in dirs:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 0:
                        que.append((nx, ny))
                        grid[nx][ny] = 1
            steps += 1

        return -1
