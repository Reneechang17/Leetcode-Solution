# Time:O(m*n), Space:O(m*n)

from collections import deque
from typing import List

class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        if not rooms or not rooms[0]:
            return

        m, n = len(rooms), len(rooms[0])
        que = deque()

        for i in range(m):
            for j in range(n):
                if rooms[i][j] == 0:
                    que.append((i, j))

        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        while que:
            r, c = que.popleft()

            for dr, dc in dirs:
                nr, nc = r + dr, c + dc

                if 0 <= nr < m and 0 <= nc < n and rooms[nr][nc] == 2147483647:
                    rooms[nr][nc] = rooms[r][c] + 1
                    que.append((nr, nc))
