// Medium
// Matrix
// O(mn)
// https://leetcode.cn/problems/set-matrix-zeroes/

class Solution {
  // check the first row and col, and use flag to record whether we need to set the first row and col as zero
  // then we check from second row and col, cur pos is zero, we need to mark the cur row and col as zero
  // then we iterate the second row and col again to follow the mark to set zero
  // finally, we can follow the flag to determine if we need to set first row and col as zero
  public void setZeroes(int[][] matrix) {
      int m = matrix.length, n = matrix[0].length;

      boolean firstRowZero = false;
      boolean firstColZero = false;

      // check first row and first col
      for (int j = 0; j < n; j++) {
          if (matrix[0][j] == 0) {
              firstRowZero = true;
              break;
          }
      }

      for (int i = 0; i < m; i++) {
          if (matrix[i][0] == 0) {
              firstColZero = true;
              break;
          }
      }

      // then check others rows and cols to see if we need to mark zero
      for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
              if (matrix[i][j] == 0) {
                  matrix[i][0] = 0;
                  matrix[0][j] = 0;
              }
          }
      }

      // then we follow the mark to set remain's zero
      for (int i = 1; i < m; i++) {
          if (matrix[i][0] == 0) {
              for (int j = 1; j < n; j++) {
                  matrix[i][j] = 0;
              }
          }
      }
      
      for (int j = 1; j < n; j++) {
          if (matrix[0][j] == 0) {
              for (int i = 1; i < m; i++) {
                  matrix[i][j] = 0;
              }
          }
      }

      // if the first row or col need to set as zero
      if (firstRowZero) {
          for (int j = 0; j < n; j++) {
              matrix[0][j] = 0;
          }
      }

      if (firstColZero) {
          for (int i = 0; i < m; i++) {
              matrix[i][0] = 0;
          }
      }
  }
}
