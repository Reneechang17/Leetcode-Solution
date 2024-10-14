// Hard
// DP, Memoization
// O(n^2)
// https://leetcode.cn/problems/count-different-palindromic-subsequences/

class Solution {
  private final int MOD = (int) 1e9 + 7;

  public int countPalindromicSubsequences(String s) {
      int n = s.length();
      long[][][] dp = new long[n][n][4];

      for (int i = 0; i < n; i++) {
          dp[i][i][s.charAt(i) - 'a'] = 1;
      }

      for (int len = 2; len <= n; len++) {
          for (int i = 0; i + len <= n; i++) {
              int j = i + len - 1; // 右邊界

              for (char c = 'a'; c <= 'd'; c++) {
                  int k = c - 'a';
                  if (s.charAt(i) == c && s.charAt(j) == c) {
                      dp[i][j][k] = 2 + dp[i + 1][j - 1][0] + dp[i + 1][j - 1][1] + dp[i + 1][j - 1][2] + dp[i + 1][j - 1][3];
                      dp[i][j][k] %= MOD;
                  } else if (s.charAt(i) == c) {
                      dp[i][j][k] = dp[i][j - 1][k];
                  } else if (s.charAt(j) == c) {
                      dp[i][j][k] = dp[i + 1][j][k];
                  } else {
                      dp[i][j][k] = dp[i + 1][j - 1][k];
                  }
              }
          }
      }
      long ans = 0;
      for (int k = 0; k < 4; k++) {
          ans += dp[0][n - 1][k];
      }
      return (int)(ans % MOD);
  }
}
