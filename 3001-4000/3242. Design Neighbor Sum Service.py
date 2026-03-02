# Time:O(1), Space:O(n²)

from typing import List

class NeighborSum:

    def __init__(self, grid: List[List[int]]):
        self.grid = grid
        self.n = len(grid)
        self.pos = {}
        for i in range(self.n):
            for j in range(self.n):
                self.pos[grid[i][j]] = (i, j)

    def adjacentSum(self, value: int) -> int:
        r, c = self.pos[value]
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        total = 0
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 <= nr < self.n and 0 <= nc < self.n:
                total += self.grid[nr][nc]
        return total

    def diagonalSum(self, value: int) -> int:
        r, c = self.pos[value]
        dirs = [(-1,-1),(-1,1),(1,-1),(1,1)]
        total = 0 
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 <= nr < self.n and 0 <= nc < self.n:
                total += self.grid[nr][nc]
        return total
    