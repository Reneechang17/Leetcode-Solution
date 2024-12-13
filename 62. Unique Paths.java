// Medium
// DP
// Time:O(m * n), Space:O(m * n)
// https://leetcode.cn/problems/unique-paths/

class Solution {
    // Use DP, dp[i][j] is the number of ways to reach grid(i,j)
    // For each cur cell, it can be reached from top or left
    //   -> dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // Initialize the first row and col as 1(only one way)
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
