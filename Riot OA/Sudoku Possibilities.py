"""
  Given a sudoku grid and the coordinate of a cell, calculate all possible values of that cell.
  If the cell already has a number, return the number directly; 
  if there is no possible value, return an empty list.

  1. Check if the cell is empty, if the cell already has a value, return directly
  2. Then use a set to record the appeared num in cur row, col and subgrid
  3. Iterate the num from 1 to 9, if the num is not in the set, it maybe the possible value
"""

def possibilities(puzzle, row, col):
  # if the cell has number, directly return the number
  if puzzle[row][col]:
    return [puzzle[row][col]]

  # use set to record the appeared numbers in cur row, col and subgrid
  st = set(puzzle[row]) # add cur row to set
  for i in range(9):
    st.add(puzzle[i][col]) # add cur col to set

  x = (row // 3) * 3
  y = (col // 3) * 3
  for i in range(x, x + 3):
    for j in range(y, y + 3):
      st.add(puzzle[i][j])

  # iterate from 1-9, if the number is not in the set, it maybe the possible value
  ans = []
  for i in range(1, 10):
    if i not in st:
      ans.append(i)
  ans.sort()
  return ans

# Time: O(9) -> O(1) -> constant time
# Space: O(1), set store the num from 1-9, and ans store at most 9 numbers
