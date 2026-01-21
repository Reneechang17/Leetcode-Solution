"""
  If a given cell in a Sudoku is pinned, means it has a unique possible value that can fit into specific cell
  Why we need to find pinned num? If we can find a pinned num, we can directly fill it
  and if no pinned num, means we cannot make sure the value of this cell in current state
  1. First, use the helper function to find all possible val of the empty cell
  2. Then identify related cells in the same row, col, and subgrid
  3. Check each possible val to see if it is unique in its row/col/subgrid(cannot fit in any other cells)
  4. If a number is unique, it is pinned to the cell, return the number; otherwise, return 0
"""
def pinned(sudoku, row, col):
  def find_possible_num(board, r, c):
    if board[r][c] != 0:
      return set()
    possible = set(range(1, 10))
    # Exclude the num that appear in same row/col/subgrid
    possible -= set(board[r]) # exclude row values
    possible -= {board[i][c] for i in range(9)} 
    x, y = (r // 3) * 3, (c // 3) * 3
    possible -= {board[i][j] for i in range(x, x + 3) for j in range(y, y + 3)} 
    return possible

  # basecase: if the cell already has a num, or no possible val
  if sudoku[row][col] != 0:
    return 0

  possible_nums = find_possible_num(sudoku, row, col)
  if not possible_nums:
    return 0

  # Helper: Check if the given val can fit in any other cells
  def possible_x(x, cells):
    for (r, c) in cells:
      if sudoku[r][c] == 0: # Only consider empty cells
        if x in find_possible_num(sudoku, r, c): 
          return True # means x can fit in other cells
    return False

  # Collect other empty cells in same row/col/subgrid
  # Help to check if a val can only fit in the cur cell
  row_cells = [(row, c) for c in range(9) if c != col and sudoku[row][c] == 0] # exclude the cur col and filled cells
  col_cells = [(r, col) for r in range(9) if r != row and sudoku[r][col] == 0] # exclude the cur row and filled cells
  x, y = (row // 3) * 3, (col // 3) * 3
  subgrid_cells = [(r, c) for r in range(x, x + 3) for c in range(y, y + 3) if (r, c) != (row, col) and sudoku[r][c] == 0]

  # Check if x is the pinned num in cur cell, means it can only fit in the cur cell
  for x in possible_nums:
    # if possible_x return True, means x can fit in other cells
    # "not" as inverse logic, if possible_x return False, means x is unique in its r/c/sub
    row_block = not possible_x(x, row_cells) 
    col_block = not possible_x(x, col_cells)
    subgrid_block = not possible_x(x, subgrid_cells)
    # If x is unique in its row, column, or subgrid, it must go in the current cell.
    if row_block or col_block or subgrid_block: 
      return x
  return 0 # If no pinned val is found, return 0
  
# Time:O(1)per cell due to fixed board size
# Space:O(1)->possible_nums requires O(9) space/row_cells, col_cells, subgrid_cells require O(9) space(list)
