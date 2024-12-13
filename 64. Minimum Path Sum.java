// Medium
// DP
// Time:O(m * n), Space:O(m * n)
// https://leetcode.cn/problems/minimum-path-sum/

class Solution {
    // Use DP: dp[i][j] represents the min path sum to reach grid[i][j]
    // Initialize the first row and col since they have only one possible path
    // For each cell, choose the smaller value between the top or left and add cur value
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // fill first row/col
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // fill the rest table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
