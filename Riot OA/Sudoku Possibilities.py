"""
  Given a sudoku grid and the coordinate of a cell, calculate all possible values of that cell.
  If the cell already has a number, return the number directly; 
  if there is no possible value, return an empty list.

  1. Check if the cell is empty, if the cell already has a value, return directly; if the value is 0, calculate the possible values
  2. Iterate the current row, col, and subgrid, and add all appeared numbers to a set
  3. Iterate from 1 to 9, if the number is not in the set, it is one of the possible values of the cell

"""

def possibilities(puzzle, row, col):
  if puzzle[row][col]:
    return [puzzle[row][col]]

  # 用set记录当前行列已经出现的数字
  st = set(puzzle[row]) # 当前行的数字
  for i in range(9):
    st.add(puzzle[i][col]) # 当前列的数字

  # 找到当前单元格所在的子网格, 将子网格中的数字加入到set中
  x = (row // 3) * 3
  y = (col // 3) * 3
  for i in range(x, x + 3):
    for j in range(y, y + 3):
      st.add(puzzle[i][j])

  # 遍历1-9, 如果数字不在set中, 则为该单元格的可能值之一
  ans = []
  for i in range(1, 10):
    if i not in st:
      ans.append(i)
  ans.sort()
  return ans

# Time: O(9) -> O(1) -> constant time
# Space: O(1)