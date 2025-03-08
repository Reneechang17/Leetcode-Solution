// Medium
// DP
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/edit-distance/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp represent the min operations to change word1[0..i] to word2[0..j]
        int[][] dp = new int[m + 1][n + 1]; 

        // initialize dp arr
        // change word1[0..i] to empty string need i times deletion 
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // change empty string to word2[0..j] need j times insertion
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no need operation
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
