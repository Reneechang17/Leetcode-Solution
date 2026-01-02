# Time:O(n!),Space:O(n)

class Solution:
    def totalNQueens(self, n: int) -> int:
        self.count = 0

        cols = set()
        diag1 = set()
        diag2 = set()

        def backtracking(row):
            if row == n:
                self.count += 1
                return

            for col in range(n):
                if col in cols or (row - col) in diag1 or (row + col) in diag2:
                    continue

                cols.add(col)
                diag1.add(row - col)
                diag2.add(row + col)

                backtracking(row + 1)

                cols.remove(col)
                diag1.remove(row - col)
                diag2.remove(row + col)

        backtracking(0)
        return self.count
    