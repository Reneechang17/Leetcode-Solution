// Hard
// Backtracking
// Time:O(4^(m*n)), Space:O(m*n)
// https://leetcode.cn/problems/unique-paths-iii/

class Solution {
  private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  private int rows, cols, path = 0, empty = 0;
  private int[][] grid;

  public int uniquePathsIII(int[][] grid) {
      this.grid = grid;
      this.rows = grid.length;
      this.cols = grid[0].length;

      int startRow = -1, startCol = -1;

      for (int i = 0; i < rows; i++) {
          for (int j = 0; j< cols; j++) {
              if (grid[i][j] == 0) {
                  empty++;
              } else if (grid[i][j] == 1) {
                  startRow = i;
                  startCol = j;
                  empty++;
              } else if (grid[i][j] == 2) {
                  empty++;
              }
          }
      }
      backtracking(startRow, startCol, 1);
      return path;
  }

  private void backtracking(int i, int j, int vis) {
      if (grid[i][j] == 2) {
          // reach the end and go through all empty cells
          if (vis == empty) {
              path++;
          }
          return;
      }

      int original = grid[i][j];
      grid[i][j] = -2;

      for (int[] dir : DIRS) {
          int i2 = i + dir[0], j2 = j + dir[1];

          if (isValid(i2, j2)) {
              backtracking(i2, j2, vis + 1);
          }
      }

      grid[i][j] = original;
  }

  private boolean isValid(int i, int j) {
      if (i < 0 || i >= rows || j < 0 || j >= cols) {
          return false;
      }
      
      return grid[i][j] == 0 || grid[i][j] == 2;
  }
}
