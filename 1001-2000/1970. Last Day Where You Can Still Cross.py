# Time:O(m × n × log(m × n))
# Space: O(m × n)

from collections import deque
from typing import List

class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:

        def can_cross(day):
            grid = [[0] * col for _ in range(row)]
            for i in range(day):
                r, c = cells[i]
                grid[r - 1][c - 1] = 1 # water
            
            que = deque()
            
            for c in range(col):
                if grid[0][c] == 0:
                    que.append((0, c))
                    grid[0][c] == 2 # mark as vis

            dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

            while que:
                r, c = que.popleft()
                
                if r == row - 1:
                    return True
                
                for dr, dc in dirs:
                    nr, nc = r + dr, c + dc
                    
                    if 0 <= nr < row and 0 <= nc < col and grid[nr][nc] == 0:
                        grid[nr][nc] = 2
                        que.append((nr, nc))
            
            return False

        left, right = 1, len(cells)
        res = 0
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if can_cross(mid):
                res = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return res
    