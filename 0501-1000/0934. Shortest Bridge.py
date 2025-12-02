# Medium
# BFS, DFS
# Time:O(n^2), Space:O(n^2)
# https://leetcode.cn/problems/shortest-bridge/

from typing import *
from collections import deque

class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        # DFS find the first island
        def dfs(r, c):
            if r < 0 or r >= n or c < 0 or c >= n or grid[r][c] != 1:
                return
            grid[r][c] = 2
            que.append((r, c, 0))
            for dr, dc in dirs:
                dfs(r + dr, c + dc)
        
        # find the starter of first island
        que = deque()
        found = False
        for i in range(n):
            if found:
                break
            for j in range(n):
                if grid[i][j] == 1:
                    dfs(i , j)
                    found = True
                    break
        
        # fidnd the second island
        while que:
            r, c, dist = que.popleft()

            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                
                if 0 <= nr < n and 0 <= nc < n:
                    if grid[nr][nc] == 1:
                        return dist
                    elif grid[nr][nc] == 0:
                        grid[nr][nc] = 2
                        que.append((nr, nc, dist + 1))
        return -1
    