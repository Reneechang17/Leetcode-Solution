// Medium
// DP
// O(m * n)
// https://leetcode.com/problems/unique-paths-ii/

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      // 題目參數沒有傳長度，要自己定義
      int m = obstacleGrid.length, n = obstacleGrid[0].length;
      int[][] dp = new int[m][n];

      // 初始化, 如果遇到障礙物直接break
      for (int i = 0; i < m; i++) {
          if (obstacleGrid[i][0] == 1) break;
          dp[i][0] = 1;
      }

      for (int j = 0; j < n; j++) {
          if (obstacleGrid[0][j] == 1) break;
          dp[0][j] = 1;
      }

      for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
              if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
              else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          }
      }
      return dp[m - 1][n - 1];
  }
}

/**
 * DP不同路徑問題：在62的情境上，加入障礙物
 * 
 * 這題的參數並沒有傳入長度，所以要先定義長度
 * 剩下思路和62題差不多，但是在初始化以及找dp的過程中，如果遇到障礙物就break(初始化) or dp[i][j]歸零
 * 因為遇到障礙物的話這條路子就沒了
 **/