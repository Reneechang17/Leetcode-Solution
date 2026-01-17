# Time:O(1), Space:O(rows*26)

class Spreadsheet:

    def __init__(self, rows: int):
        self.rows = rows
        self.cols = 26
        self.grid = [[0] * self.cols for _ in range(rows)]

    def _parse_cell(self, cell: str) -> tuple[int, int]:
        col = ord(cell[0]) - ord("A")
        row = int(cell[1:]) - 1
        return row, col

    def setCell(self, cell: str, value: int) -> None:
        r, c = self._parse_cell(cell)
        self.grid[r][c] = value

    def resetCell(self, cell: str) -> None:
        r, c = self._parse_cell(cell)
        self.grid[r][c] = 0

    def _get_cell_value(self, ref: str) -> int:
        if ref.isdigit():
            return int(ref)
        r, c = self._parse_cell(ref)
        return self.grid[r][c]

    def getValue(self, formula: str) -> int:
        expr = formula[1:]
        parts = expr.split("+")
        val1 = self._get_cell_value(parts[0])
        val2 = self._get_cell_value(parts[1])
        return val1 + val2
    