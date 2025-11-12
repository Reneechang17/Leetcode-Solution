// Medium
// DP
// Time:O(n^3),Space:O(n^2)
// https://leetcode.cn/problems/guess-number-higher-or-lower-ii/

class Solution {
    // dp[i][j]: min cost to guess a num in the range [i,j]
    // For each k in range[i,j], calculate the cost of guessing k and choose the min
    //  => dp[i][j] = min(max(dp[i][k-1], dp[k+1][j]) + k), k is the guessed num
    // Result stored in dp[1][n], for the entire range[1,n]
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n]; 
    }
}
