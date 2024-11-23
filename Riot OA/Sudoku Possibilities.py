"""
  Given a sudoku grid and a cell, find all possible values of cell.
  If the cell has a number, return the number directly; 
  if no possible value, return an empty list.
  1. Check if the cell is empty, if the cell has a value, return directly
  2. Then use a set to record the appeared num in cur row, col and subgrid
  3. Iterate the num from 1-9, if the num is not in the set, 
  means this number not appear in same row/col/subgrid ->the possible value
"""
def possibilities(puzzle, row, col):
  # If the cell has number, directly return the number
  if puzzle[row][col]:
    return [puzzle[row][col]]

  # Use set to record the appeared numbers in cur row/col/subgrid
  st = set(puzzle[row]) # Add num in cur row to set
  for i in range(9):
    st.add(puzzle[i][col]) # Add cur col to set
  # Find the subgrid of the cur cell
  x = (row // 3) * 3
  y = (col // 3) * 3 # Start index
  for i in range(x, x + 3):
    for j in range(y, y + 3):
      st.add(puzzle[i][j])

  # Iterate 1-9, if the num not in the set->possible value
  ans = []
  for i in range(1, 10):
    if i not in st:
      ans.append(i)
  ans.sort()
  return ans
  
# Time:O(27)->O(1):check row/col/subgrid 9*3=27
# Space:O(9)->O(1):set store the num from 1-9, ans store at most 9 nums
