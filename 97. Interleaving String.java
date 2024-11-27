// Medium
// DP
// Time:O(mn),Space:O(mn)
// https://leetcode.cn/problems/interleaving-string/

class Solution {
  // dp[i][j]，表示s1的前i个字符和s2的前j个字符是否能交错组成s3的前i+j个字符
  // 如果当前字符来自 s1：dp[i][j] = dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]
  // 如果当前字符来自 s2：dp[i][j] = dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]
  public boolean isInterleave(String s1, String s2, String s3) {
      int m = s1.length(), n = s2.length();
      // basecase
      if (m + n != s3.length()) return false;

      boolean[][] dp = new boolean[m + 1][n + 1];

      // 初始化
      // dp[0][0] = 空字符串交错可以组成空字符串，
      // 第一列:dp[i][0] = dp[i - 1][0] && s1[i - 1] == s3[i - 1]（s1 的前i个字符组成s3的前i个字符）
      // 第一行:dp[0][j] = dp[0][j - 1] && s2[j - 1] == s3[j - 1]（s2 的前j个字符组成s3的前j个字符）
      dp[0][0] = true;
      for (int i = 1; i <= m; i++) {
          dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
      }

      for (int j = 1; j <= n; j++) {
          dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
          }
      }
      return dp[m][n];
  }
}
