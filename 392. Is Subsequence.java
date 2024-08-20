// Easy
// DP
// O(m + n)
// https://leetcode.com/problems/is-subsequence/

class Solution {
  public boolean isSubsequence(String s, String t) {
      int m = s.length(), n = t.length();
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (s.charAt(i - 1) == t.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
              } else {
                  dp[i][j] = dp[i][j - 1];
              }
          }
      }

      if (dp[m][n] == m) {
          return true;
      } else {
          return false;
      }
  }
}

/**
 * 判斷s是否為t的子序列
 * 
 * dp數組表示s前i個字符與t前j個字符的最長公共子序列長度
 * 如果s.charAt(i - 1) != t.charAt(j - 1)，則需要刪掉元素，繼續匹配 
 * 如果t要把當前的j-1刪掉，那麼dp[i][j]的數值其實就是s[i - 1]和t[j - 2]的比較 => dp[i][j] = dp[i][j - 1]
 **/