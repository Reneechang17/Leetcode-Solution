"""
  给定某单元格的坐标(row, col), 返回其所在子网格的所有坐标。
  Given a 9*9 sudoku includes integers from 1-9, divided into nine 3*3 subgrids.
  The input is the coordinate of a cell, return all coordinates of the subgrid it belongs to.

  1. First to find the start index of the subgrid
  which can be achieved by divide by 3 to locate the subgrids, then multiply by 3 
  2. Use for loops to iterate all cells in the subgrid, collect all coordinates of the subgrid
  the loop is from (x, y) to (x + 2, y + 2)

  If row=4, col=7
  x=(4//3)*3=3, y=(7//3)*3=6, The subgrid starts at (3,6)
  If x=3, y=6, i=3,4,5, j=6,7,8
  [[3, 6], [3, 7], [3, 8],
  [4, 6], [4, 7], [4, 8],
  [5, 6], [5, 7], [5, 8]]
"""

def neighbor(row, col):
  x = (row // 3) * 3
  y = (col // 3) * 3
  ans = []

  for i in range(x, x + 3):
    for j in range(y, y + 3):
      ans.append([i, j])
    return ans

# Time: O(1)
# Space: O(1), the size of the subgrid is fixed