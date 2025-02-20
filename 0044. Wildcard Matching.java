// Hard
// DP
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/wildcard-matching/

class Solution {
  public boolean isMatch(String s, String p) {
      int m = s.length(), n = p.length();
      boolean[][] dp = new boolean[m + 1][n + 1];
      dp[0][0] = true;
      for (int j = 1; j <= n; j++) {
          if (p.charAt(j - 1) == '*') {
              dp[0][j] = dp[0][j - 1];
          }
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              char sc = s.charAt(i - 1);
              char pc = p.charAt(j - 1);

              if (pc == sc || pc == '?') {
                  dp[i][j] = dp[i - 1][j - 1];
              } else if (pc == '*') {
                  // * can match zero or multi chars
                  dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
              }
          }
      }
      return dp[m][n];
  }
}

// dp[i][j]表示s[0..i-1]和p[0..j-1]是否匹配
// 初始化：dp[0][0]=true，空字符串和空模式匹配
//   如果pattern以*开头，则dp[0][j]=true => 因为*可以匹配空字符串
