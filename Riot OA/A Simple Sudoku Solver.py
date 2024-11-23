"""
  Based on the problem 3, we need to develop a simple sudoku solver. 
  to keep checking each cell and find the possible values:
    a. If the cell only has one possible value, fill the cell with this number
    b. If all the cells are filled, the sudoku is solved
    c. If no possible val or no only one possible val, the sudoku is unsolvable
1. First, we copy the board to avoid modifying the original board
2. And use helper function to find all the possible values for each empty cell  
3. Iterate the solving process until the sudoku is solved or unsolvable
  1. First, we find possible values using helper function, and store them in a dictionary
  2. Check if cell has only one possible val, if no, means the algorithm cannot proceed
     If yes, fill the cell with this value, mark the progress as finished
  3. Looping process until either the board is completed or no further progress can be made
"""
def solver(sudoku):
  import copy
  def find_possible_num(board, row, col):
    if board[row][col] != 0:
      return set()
    possible = set(range(1, 10)) # Set store 1-9
    # Exclude the num that appear in same row/col/subgrid
    possible -= set(board[row]) 
    possible -= {board[i][col] for i in range(9)}
    x, y = (row // 3) * 3, (col // 3) * 3
    possible -= {board[r][c] for r in range(x, x + 3) for c in range(y, y + 3)}
    return possible
  
  board = copy.deepcopy(sudoku)
  while True:
    # Track whether progress is made in the cur iteration
    progress = False
    # Dictionary to store possible numbers for each empty cell
    possible_nums = {}
    for row in range(9):
      for col in range(9):
        if board[row][col] == 0: # Only check empty cells
          possible = find_possible_num(board, row, col)
          if not possible: # If no, return empty list
            return []
          possible_nums[(row, col)] = possible # Store possible values in dic
    # Check completed:no empty cell->Sudoku is solved
    if not possible_nums:
      return board
    # If there is only one possible value, fill the cell with this val
    # next(iter(nums)) creates iterator for set, retrieves the only element from set
    # only_one_candidates is a dic mapping cell to their single possible val
    only_one_candidates = {cell: next(iter(nums)) for cell, nums in possible_nums.items() if len(nums) == 1}

    if not only_one_candidates: # If no cells with a single value, stop
      return []
    # Fill cells with this value
    for (row, col), number in only_one_candidates.items():
      board[row][col] = number
      progress = True # means one cell is filled
    # If no progress is made, return failure
    if not progress:
      return []
# Time:O(1),sized is fixed at 9times9,all operations are bounded by constant factors
# Space:O(1),deepcopy board:O(1),set:O(9),dic:O(81*9)->O(1),81cells for keys,to map to a set(9)
# Why use dic to store possible nums? Since we later need to check if there is only one candidate for the cell
# only_one_candidates = {cell: next(iter(nums)) for cell, nums in possible_nums.items() if len(nums) == 1}
#   iter(nums) creates an iterator for the set, next(iter(nums)) retrieves the only element from set
#   Iterate the items in possible_nums, if the length of nums is 1, then store cell and the only val in dic
