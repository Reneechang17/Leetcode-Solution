// Medium
// DP
// O(mn)
// https://leetcode.com/problems/distinct-subsequences/

class Solution {
  public int numDistinct(String s, String t) {
      // 簡單來說就是找s中有幾個t
      int m = s.length(), n = t.length();
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 0; i <= m; i++) {
          dp[i][0] = 1; // 任何長度為s都只有一種方法形成空字符串t
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (s.charAt(i - 1) == t.charAt(j - 1)) {
                  // 可以考慮是否使用s[i-1]
                  dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
              } else {
                  // 可以從不使用s[i-1]過來
                  dp[i][j] = dp[i - 1][j];
              }
          }
      }
      return dp[m][n];
  }
}

/**
 * 不同的子序列：找s中有多少個不同的子序列等於t
 * 
 * 這題是一個經典的動態規劃問題，dp[i][j]表示s的前i個字符中有多少個子序列等於t的前j個字符
 * 初始化：dp[i][0] = 1，表示任何長度為i的字符串都只有一種方法形成空字符串t
 * dp[0][j] = 0，表示空字符串s不可能形成非空字符串t
 * 
 * 狀態轉移：如果s[i-1] == t[j-1]，則可以考慮是否使用s[i-1]，dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 * 如果s[i-1] != t[j-1]，則只能從不使用s[i-1]過來，dp[i][j] = dp[i-1][j]
 **/