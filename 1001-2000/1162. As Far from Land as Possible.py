# Time:O(m*n), Space:O(m*n)

from collections import deque
from typing import List

class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dist = [[-1] * n for _ in range(m)]
        que = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    dist[i][j] = 0
                    que.append((i, j))
        
        if not que or len(que) == m * n:
            return -1
        
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        ans = -1
        while que:
            x, y = que.popleft()
            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and dist[nx][ny] == -1:
                    dist[nx][ny] = dist[x][y] + 1
                    que.append((nx, ny))
                    ans = max(ans, dist[nx][ny])
        return ans
    