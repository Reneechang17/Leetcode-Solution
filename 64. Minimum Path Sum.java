// Medium
// DP
// O(m * n)
// https://leetcode.com/problems/minimum-path-sum/

class Solution {
  public int minPathSum(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] dp = new int[m][n];

      dp[0][0] = grid[0][0];

      for (int i = 1; i < m; i++) {
          dp[i][0] = dp[i - 1][0] + grid[i][0];
      }

      for (int j = 1; j < n; j++) {
          dp[0][j] = dp[0][j - 1] + grid[0][j];
      }

      for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
              dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
          }
      }
      return dp[m - 1][n - 1];
  }
}

/**
 * 最小路徑總和：在m*n網格中，每個格子都有一個非負數，找出一條從左上角到右下角的路徑，使得路徑總和為最小。每次只能向下或向右移動一步
 * 
 * 這題乍看之下可以用貪心，每次都找最小的路徑，但是這個不能在全局找最優解
 * 所以嘗試用dp，對於每個dp[i][j]，可以是從上方dp[i - 1][j]或是左方dp[i][j - 1]找到
 **/