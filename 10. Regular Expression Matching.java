// Hard
// DP
// O(m * n)
// https://leetcode.com/problems/regular-expression-matching/

class Solution {
  public boolean isMatch(String s, String p) {
      int m = s.length(), n = p.length();
      boolean[][] dp = new boolean[m + 1][n + 1];
      dp[0][0] = true;

      for (int j = 2; j <= n; j++) {
          if (p.charAt(j - 1) == '*') {
              dp[0][j] = dp[0][j - 2];
          }
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                  dp[i][j] = dp[i - 1][j - 1];
              } else if (p.charAt(j - 1) == '*') {
                  dp[i][j] = dp[i][j - 2];
                  if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                      dp[i][j] = dp[i][j] || dp[i - 1][j];
                  }
              }
          }
      }
      return dp[m][n];
  }
}

/**
 * 正則表達式匹配：檢查字符串s是否可以完全匹配pattern p
 * '.'表示任意單個字符，'*'表示前一個字符可以出現0次或多次
 * 
 * 這題可以用動態規劃做，dp[i][j]表示s的前i個字符是否可以匹配p的前j個字符
 * 初始化二維數組dp，dp[0][0]為true，表示空字符串可以匹配空正則表達式
 * 對於任何非空模式與空字符串的匹配，需要特別處理'*'，因為'*'可以表示前一個字符出現0次，所以p="a*b*c*"可以匹配空字符串
 * 
 * DP邏輯：
 * 如果當前字符匹配或是模式字符是'.'，則dp[i][j] = dp[i - 1][j - 1]
 * 如果當前字符為'*'，則有兩種情況：
 * 1. 前一個元素出現0次，即dp[i][j] = dp[i][j - 2]
 * 2. 如果字符串的當前字符與'*'之前的字符匹配（或是*之前的字符是.)，則dp[i][j] = dp[i - 1][j]
 **/