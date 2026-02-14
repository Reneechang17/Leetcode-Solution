# Time:O(mn), Space:O(mn)

from collections import deque
from typing import List

class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        m, n = len(maze), len(maze[0])
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]

        que = deque([(entrance[0], entrance[1], 0)])
        vis = [[False] * n for _ in range(m)]
        vis[entrance[0]][entrance[1]] = True

        while que:
            r, c, steps = que.popleft()

            if (r == 0 or r == m - 1 or c == 0 or c == n - 1) and (r, c) != (entrance[0], entrance[1]):
                return steps
            
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and not vis[nr][nc] and maze[nr][nc] == '.':
                    vis[nr][nc] = True
                    que.append((nr, nc, steps + 1))
        
        return -1
    