// Medium
// DP
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/delete-operation-for-two-strings/

class Solution {
    // We can serve it as longest common subsequence(LCS)
    // The min deletions are the sum of two strs's length - twice the LCS
    // dp[i][j] represents the LCS length of word1[0..i-1] and word2[0..j-1]
    //  - if word1[i-1]==word2[j-1], extend LCS, else take the max of prev states
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
