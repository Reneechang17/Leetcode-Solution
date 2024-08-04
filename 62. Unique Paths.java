// Medium
// DP
// O(m * n)
// https://leetcode.com/problems/unique-paths/

class Solution {
  public int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];

      for (int i = 0; i < m; i++) {
          dp[i][0] = 1;
      }

      for (int j = 0; j < n; j++) {
          dp[0][j] = 1;
      }

      for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
              dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          }
      }
      return dp[m - 1][n - 1];
  }
}

/**
 * DP不同路徑問題：在m*n的網格中找到從左上角到右下角的所有唯一路徑的數量，只允許向右或是向下移動
 * 
 * 思路：每次移動只有兩個選擇，不是向下就是向右
 * 可以用dp來嘗試找所有路徑，dp數組表示的是從起點出發到終點有x條路徑
 * 而dp[i][j]可以從左邊或是上面得出，所以就從左到右遍歷
 * 
 * 初始化：從(0, 0)位置到(i, 0)以及(0, j)的路徑都只有一條，可以填充1
 **/