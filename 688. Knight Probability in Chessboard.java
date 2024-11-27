// Medium
// DP
// Time:O(kn^2),Space:O(kn^2)
// https://leetcode.cn/problems/knight-probability-in-chessboard/

class Solution {
  private static final int[][] DIRS = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

  public double knightProbability(int n, int k, int row, int column) {
      double[][][] memo = new double[k + 1][n][n];
      return dfs(k, row, column, n, memo);
  }

  private double dfs(int k, int i, int j, int n, double[][][] memo) {
      if (i < 0 || j < 0 || i >= n || j >= n) {
          return 0;
      }
      if (k == 0) {
          return 1;
      }
      if (memo[k][i][j] > 0) {
          return memo[k][i][j];
      }
      double res = 0.0;
      for (int[] dir : DIRS) {
          res += dfs(k - 1, i + dir[0], j + dir[1], n, memo);
      }
      return memo[k][i][j] = res / DIRS.length;
  }
}
