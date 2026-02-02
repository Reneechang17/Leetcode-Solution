# Time:O(mn), Space:O(mn)

from collections import deque
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        que = deque()
        fresh = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    que.append((r, c))
                elif grid[r][c] == 1:
                    fresh += 1
        
        if fresh == 0:
            return 0

        minutes = 0
        dirs = [(1,0), (-1,0), (0,1), (0,-1)]

        while que and fresh > 0:
            for _ in range(len(que)):
                r, c = que.popleft()

                for dr, dc in dirs:
                    nr, nc = r + dr, c + dc

                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        fresh -= 1
                        que.append((nr, nc))
            minutes += 1
        
        return minutes if fresh == 0 else -1
    