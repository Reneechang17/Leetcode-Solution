"""
  在数独中, 某个数字x被钉住在一个单元格(row, col)中, 满足以下条件:
  1. x是在当前(row,col)中的一个可能值 -> 可以用problem 3的方法找到
  2. 以下至少一个条件成立:
    - x是当前行(row)中的唯一可能值
    - x是当前列(col)中的唯一可能值
    - x是当前子网格中的唯一可能值
  如果某个数字被钉住, 则该数字一定是在当前单元格的解, 否则返回0表示没有被钉住

  思路：
  1. 首先找到当前单元格的所有可能值
  2. 检查唯一性
     如果这个单元格没有可能值, 则立刻返回0
     对于每个可能值x, 检查x是否是当前行, 列, 子网格的唯一可能值
      遍历当前单元格的所有可能值x
      如果x是当前行列和子网格的唯一可能值, 则返回x; 如果没有符合条件的数字, 返回0
"""

def pinned(sudoku, row, col):
  # helper function to fina all possible values of a cell
  def find_possible_num(board, r, c):
    if board[r][c] != 0:
      return set()
    possible = set(range(1, 10))

    possible -= set(board[r]) # exclude row values
    possible -= {board[i][c] for i in range(9)} # exclude column values

    x, y = (r // 3) * 3, (c // 3) * 3
    possible -= {board[i][j] for i in range(x, x + 3) for j in range(y, y + 3)} # exclude subgrid values
    return possible

## Start 
  # If the cell already has a number, return 0
  if sudoku[row][col] != 0:
    return 0

  # Find all possible values of the cell
  possible_nums = find_possible_num(sudoku, row, col)
  if not possible_nums:
    return 0

  # helper function to check if a number x is unqiue in a row, column, or subgrid
  def possible_x(x, cells):
    for (r, c) in cells:
      if sudoku[r][c] == 0: # we only consider empty cells
        if x in find_possible_num(sudoku, r, c):
          return True
    return False

  # collect other empty cells in the same row, column, and subgrid
  row_cells = [(row, c) for c in range(9) if c != col and sudoku[row][c] == 0]
  col_cells = [(r, col) for r in range(9) if r != row and sudoku[r][col] == 0]
  x, y = (row // 3) * 3, (col // 3) * 3
  subgrid_cells = [(r, c) for r in range(x, x + 3) for c in range(y, y + 3) if (r, c) != (row, col) and sudoku[r][c] == 0]

  # check if any possible value is unique in row, column, or subgrid
  # which means the number is pinned 
  for x in possible_nums:
    row_block = not possible_x(x, row_cells)
    col_block = not possible_x(x, col_cells)
    subgrid_block = not possible_x(x, subgrid_cells)
    if row_block or col_block or subgrid_block:
      return x
  return 0
  
# Time: O(9 * 1) = O(1) -> constant time for the fixed-size board
# Space:O(20 + 9) = O(1) -> possible_nums requires O(9) space, and the rest are store coordinates of blank cells in the row, column, and subgrid.
