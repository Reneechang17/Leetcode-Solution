// Medium
// DP, String
// O(mn)
// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

class Solution {
  public int minimumDeleteSum(String s1, String s2) {
      int m = s1.length(), n = s2.length();
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
          dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
      }

      for (int j = 1; j <= n; j++) {
          dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1];
              } else {
                  dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
              }
          }
      }
      return dp[m][n];
  }
}

/**
 * 給定兩個字符串s1和s2，求使兩個字符串相等所需刪除的字符的ASCII值的最小和
 * 
 * 這題的經典作法是DP，類似於編輯距離的問題，但是我們關注的是ASCII值的最小刪除和而不是最小操作數
 * dp[i][j]表示的是使得s1的前i個字符與s2的前j個字符相等所需刪除的字符的ASCII值的最小和
 * 
 * 如果s1[i-1]等於s2[j-1]，則不需要刪除
 * 如果不相等，則可以選擇刪除s1的字符或是s2的字符，取兩者中較小的一個
 * 
 * 初始化
 * dp[0][j]表示s1為空與s2前j個字符相等所需刪除的ASCII值和
 * dp[i][0]表示s2為空與s1前i個字符相等所需刪除的ASCII值和
 *  **/