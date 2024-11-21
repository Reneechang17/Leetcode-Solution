"""
  Based on the problem 3, we need to develop a simple sudoku solver. To solving following:
  1. find all the possibilities of each cell
  2. if there is no possibility, return empty array, which means the puzzle is unsolvable
  3. if there is only one possibility, fill the cell with the number
  4. keep looping until all cells are filled or unsolvable

  Solution:
  1. Firstly, we copy the input board to avoid modifying the original directly
  2. Then we define a helper function to find all the possible numbers for each cell  
  3. Iterate the solving process until the sudoku is solved or unsolvable
     1. First, we track possible values using find_possible_num function, and store them in a dictionary
     2. Check if the cell have exactly one possible candidate, if no, means the algorithm cannot proceed
        If there is a single candidate, then we fill the cell with the value, mark the progress as finished
     3. Continue the above process until either the board is completed or no further progress can be made.
"""

def solver(sudoku):
  import copy

  def find_possible_num(board, row, col):
    if board[row][col] != 0:
      return set()
    
    possible = set(range(1, 10)) # Set store 1-9
    # Exclude the numbers that already appear in the same row, col and subgrid
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
        if board[row][col] == 0: # If the cell is empty
          possible = find_possible_num(board, row, col)
          if not possible: # If no possible, the board is unsolvable
            return []
          possible_nums[(row, col)] = possible # Store the possible numbers for this cell

    # Check if no empty cell, the Sudoku is solved
    if not possible_nums:
      return board
    
    # If there is only one possible candidate, fill the cell with the number
    # Iter(nums) creates an iterator for the set, retrieves the only element from set.
    # only_one_candidates is a dic store all the cells have exactly one possible val and their corresponding num.
    only_one_candidates = {cell: next(iter(nums)) for cell, nums in possible_nums.items() if len(nums) == 1}

    if not only_one_candidates: # If no cells with a single candidate, stop
      return []
    # Fill in cells with the one possible candidate
    for (row, col), number in only_one_candidates.items():
      board[row][col] = number
      progress = True # Mark the progress has been made
    
    # If no progress is made, return failure
    if not progress:
      return []


# Time: O(1), since the board sized is fixed at 9times9, all operations are bounded by constant factors
# Space: O(1), deepcopy board:O(1), set and dic stored 9 elements and up to 81 entries:O(1)

# Why use dic to store possible nums? Since we later need to check if there is only one candidate for each cell
# only_one_candidates = {cell: next(iter(nums)) for cell, nums in possible_nums.items() if len(nums) == 1}
#   iter(nums) creates an iterator for the set, next(iter(nums)) retrieves the only element from set
#   Iterate the items in possible_nums, if the length of nums is 1, then store the cell and the only num in dic
