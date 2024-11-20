"""
  给定一个9*9的数独, 包含1-9的整数, 分为九个3*3的子网格。
  给定某单元格的坐标(row, col), 返回其所在子网格的所有坐标。
  The problem give us a 9*9 sudoku, which includes integers from 1-9, divided into nine 3*3 subgrids.
  The input is the coordinate of a cell(row, col), return all coordinates of the subgrid it belongs to.

  1. First to find the start index of the subgrid
  which can be achieved by dividing row and col by 3 to locate the subgrids, then multiply by 3 
  like row 0~2 belong to the first subgrid. for row = 4, (4 // 3) * 3 = 3, so it belongs to the second subgrid, and start from row 3.
  2. Use two for loops to iterate all cells in the subgrid, collect all coordinates of the subgrid
  the loop is from (x, y) to (x + 2, y + 2)

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