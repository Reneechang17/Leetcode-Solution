// Medium
// DP
// O(mn)
// https://leetcode.com/problems/delete-operation-for-two-strings/

class Solution {
  public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
              } else {
                  dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
              }
          }
      }
      int lcs = dp[m][n];
      return m - lcs + n - lcs;
  }
}

/**
 * 兩個字符串的刪除操作：給定兩個單詞word1和word2，找到使得word1和word2相同所需的最小步數，每步可以刪除任意一個字符串中的一個字符
 * 
 * 這題可以想成LCS問題的變形，一旦我們得到了兩個字符串的最長公共子序列，即可以分別計算從word1和word2刪除到LCS的步數，最後相加即可
 **/