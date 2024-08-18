// Medium
// DP
// O(mn)
// Similar: 718
// https://leetcode.com/problems/longest-common-subsequence/

class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length(), n = text2.length();
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
              } else {
                  dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
              }
          }
      }
      return dp[m][n];
  }
}

/**
 * 最長公共子序列
 * 解法和思路和718類似
 * 
 * dp數組表示text1前i個與text2前j個字符的最長公共子序列長度
 * 如果text1[i - 1] && text2[j - 1]相等，則[i - 1][j - 1] + 1
 **/