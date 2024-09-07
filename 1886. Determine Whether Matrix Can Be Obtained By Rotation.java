// Easy
// Matrix
// O(n^2)
// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

import java.util.Arrays;

class Solution {
  public boolean findRotation(int[][] mat, int[][] target) {
      for (int i = 0; i < 4; i++) {
          if (Arrays.deepEquals(mat, target)) {
              return true;
          }
          mat = rotate90(mat);
      }
      return false;
  }

  private int[][] rotate90 (int[][] mat) {
      int n = mat.length - 1;
      int[][] newMat = new int[n + 1][n + 1];
      for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= n; j++) {
              newMat[j][n - i] = mat[i][j];
          }
      }
      return newMat;
  }
}

/**
 * 判斷矩陣是否可以通過旋轉得到目標矩陣
 * 
 * 可以通過多次旋轉巨震來檢查任何一次旋轉後是不是和目標矩陣相等，每個矩陣最多旋轉3次，分別是90度，180度，270度
 * Note：對比兩個矩陣是否相等可以使用Arrays.deepEquals()方法
 **/