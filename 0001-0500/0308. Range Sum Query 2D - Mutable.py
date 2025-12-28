from typing import List

class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix
        self.m, self.n = len(matrix), len(matrix[0])
        # maintain the prefix sum for each row
        self.row_sums = [[0] * (self.n + 1) for _ in range(self.m)]
        for i in range(self.m):
            for j in range(self.n):
                self.row_sums[i][j + 1] = self.row_sums[i][j] + matrix[i][j]

    # O(n)
    def update(self, row: int, col: int, val: int) -> None:
        delta = val - self.matrix[row][col]
        self.matrix[row][col] = val
        for j in range(col + 1, self.n + 1):
            self.row_sums[row][j] += delta

    # O(m)
    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        total = 0
        for i in range(row1, row2 + 1):
            total += self.row_sums[i][col2 + 1] - self.row_sums[i][col1]
        return total
    