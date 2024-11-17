"""
  Based on the problem 3, we need to develop a simple sudoku solver. To solving following:
  1. find all the possibilities of each cell
  2. if there is no possibility, return empty array, which means the puzzle is unsolvable
  3. if there is only one possibility, fill the cell with the number
  4. keep looping until all cells are filled or unsolvable

  1. Firstly, we need to create a copy of the puzzle to work on without changing the original puzzle
  2. Use a helper function find_possilble_num to calculate the valid numbers for each blank cell
     This part we have already implemented in problem 3
  3. Iterate the solving process until the puzzle is solved or unsolvable
     For each iteration:
     1. we first to compute the possible values with the helper function for each blank cell
        if no possibilities, return an empty array, which means the puzzle is unsolvable
        store the possibilities in a dictionary with keys as cell coordinates and values as possible numbers
     2. check for completion: if the dictionary is empty(no blank cells), return the completed board
     3. identify single candidates: If no single candidates, return an empty board, as the algorithm cannot proceed.
     4. Assign the single candidate value to the corresponding cell on the board.
        Mark progress as True to indicate that changes have been made to the board.
     5. Continue the above process until either the board is completed or no further progress can be made.
"""

def solver(sudoku):
  import copy

  def find_possible_num(board, row, col):
    if board[row][col] != 0:
      return set() # 如果单元格已经有数字, 返回空集合
    
    possible = set(range(1, 10))
    # 排除当前行列已经出现的数字
    possible -= set(board[row]) 
    possible -= {board[i][col] for i in range(9)}

    # 排除当前所在子网格已经出现的数字
    x, y = (row // 3) * 3, (col // 3) * 3
    possible -= {board[r][c] for r in range(x, x + 3) for c in range(y, y + 3)}

    return possible
  
  board = copy.deepcopy(sudoku)

  while True:
    progress = False
    # 用字典存储每个空单元格的所有可能值
    possible_nums = {}

    for row in range(9):
      for col in range(9):
        if board[row][col] == 0:
          possible = find_possible_num(board, row, col)
          if not possible:
            return []
          possible_nums[(row, col)] = possible

    # 如果没有空的单元格，返回结果
    if not possible_nums:
      return board
    
    # 如果只有一个可能的数字，我们要把他拿出来
    # iter(nums) creates an iterator for the set.
    # retrieves the first (and only) element from the iterator, which is the single possible number for that cell.
    only_one_candidates = {cell: next(iter(nums)) for cell, nums in possible_nums.items() if len(nums) == 1}

    if not only_one_candidates:
      return []

    # 填充单一可能性的单元格
    for (row, col), number in only_one_candidates.items():
      board[row][col] = number
      progress = True
    
    # 如果没有进展，停止
    if not progress:
      return []


# Time: (k^2), k is the number of initially empty cells
# Since the k is at most 81, the time complexity is O(81^2) -> O(1)
# Space: O(k), since k <= 81, that is the O(1) for the fixed-size board
