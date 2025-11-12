// Medium
// DP
// Time:O(n^3), Space:O(n^2)
// https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/

class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    int score = values[i] * values[k] * values[j];
                    score += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], score);
                }
            }
        }
        return dp[0][n - 1];
    }
}
