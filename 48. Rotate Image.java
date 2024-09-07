// Medium
// Math, Matrix
// O(n^2)
// https://leetcode.com/problems/rotate-image/

class Solution {
  public void rotate(int[][] matrix) {
      int n = matrix.length - 1;

      for (int i = 0; i <= n; i++) {
          for (int j = i; j <= n; j++) {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
      }

      for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= n / 2; j++) {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[i][n - j];
              matrix[i][n - j] = temp;            }
      }
  }
}

/**
 * 旋轉圖片
 * 
 * 這題硬想很難，通常這種聯想不到算法或是數據結構的題，可以嘗試先觀察規律
 * 通過觀察可以發現，旋轉90度等於先對角翻轉，再左右翻轉
 * 也就是先將矩陣進行轉置（即矩陣的行列互換），然後對每一行進行翻轉，就可以使原本的矩陣進行90度的旋轉
 **/