# Time:O(mn), Space:O(mn)

from typing import *
from collections import deque

class Solution:
    def containVirus(self, isInfected: List[List[int]]) -> int:
        m, n = len(isInfected), len(isInfected[0])
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        total = 0

        while True:
            vis = set()
            regions = []

            for i in range(m):
                for j in range(n):
                    if isInfected[i][j] == 1 and (i, j) not in vis:
                        # bfs to find connected region
                        cells = []
                        threatened = set()
                        walls = 0
                        que = deque([(i, j)])
                        vis.add((i, j))

                        while que:
                            x, y = que.popleft()
                            cells.append((x, y))

                            for dx, dy in dirs:
                                nx, ny = x + dx, y + dy
                                if 0 <= nx < m and 0 <= ny < n:
                                    if isInfected[nx][ny] == 0:
                                        threatened.add((nx, ny))
                                        walls += 1
                                    elif isInfected[nx][ny] == 1 and (nx, ny) not in vis:
                                        vis.add((nx, ny))
                                        que.append((nx, ny))
                        regions.append((cells, threatened, walls))
            if not regions:
                break
            
            idx = max(range(len(regions)), key=lambda i: len(regions[i][1]))
            if not regions[idx][1]:
                break
            
            for x, y in regions[idx][0]:
                isInfected[x][y] = -1
            total += regions[idx][2]

            for i, (cells, threatened, _) in enumerate(regions):
                if i != idx:
                    for x, y in threatened:
                        isInfected[x][y] = 1
        return total
    