"""
  The function pinned determines if a given cell in a Sudoku is pinned, means it has a unique possible value that
  can only fit into specific cell. If a number is pinned, it is guaranteed to belong in that cell based on the cur state of board

  Solution:
  1. First, we use the find_possible_num function to find all possible val of the cell
  2. Then identify related cells in the same row, col, and subgrid
  3. Check each possible val to see if it is unique in its row, col, or subgrid(cannot fit in any other cells)
  4. If a number is unique, it is pinned to the cell, return the number; otherwise, return 0

"""

def pinned(sudoku, row, col):
  # helper function to fina all possible values of a cell
  def find_possible_num(board, r, c):
    if board[r][c] != 0:
      return set()

    possible = set(range(1, 10))
    # Exclude the numbers that already appear in the same row, col and subgrid
    possible -= set(board[r]) # exclude row values
    possible -= {board[i][c] for i in range(9)} 
    x, y = (r // 3) * 3, (c // 3) * 3
    possible -= {board[i][j] for i in range(x, x + 3) for j in range(y, y + 3)} 
    return possible

  # basecase: if the cell already has a number, or has no possibilites, return 0
  if sudoku[row][col] != 0:
    return 0

  possible_nums = find_possible_num(sudoku, row, col)
  if not possible_nums:
    return 0

  # Helper: Check if a given value can fit in any other cells
  def possible_x(x, cells):
    for (r, c) in cells:
      if sudoku[r][c] == 0: # we only consider empty cells
        if x in find_possible_num(sudoku, r, c): # if x is a possible val for the cell
          return True
    return False

  # Collect other empty cells in the same row, col, and subgrid
  row_cells = [(row, c) for c in range(9) if c != col and sudoku[row][c] == 0] # exclude the cur col and filled cells
  col_cells = [(r, col) for r in range(9) if r != row and sudoku[r][col] == 0] # exclude the cur row and filled cells
  x, y = (row // 3) * 3, (col // 3) * 3
  subgrid_cells = [(r, c) for r in range(x, x + 3) for c in range(y, y + 3) if (r, c) != (row, col) and sudoku[r][c] == 0]

  # Check if x is the only num that can fit in the row/col/subgrid where the cell is located
  # If so, that means x is unique to the cell, means it is pinned
  for x in possible_nums:
    row_block = not possible_x(x, row_cells)
    col_block = not possible_x(x, col_cells)
    subgrid_block = not possible_x(x, subgrid_cells)
    if row_block or col_block or subgrid_block:
      return x
  return 0 # If no pinned val is found, return 0
  
# Time: O(1) per cell due to fixed board size
# Space:O(1)-> possible_nums requires O(9) space / row_cells, col_cells, subgrid_cells require O(9) space(list)
