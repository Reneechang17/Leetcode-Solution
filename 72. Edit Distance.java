// Medium
// DP
// O(mn)
// https://leetcode.com/problems/edit-distance/

class Solution {
  public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();
      int[][] dp = new int[m + 1][n + 1];

      // 將word1前i個字符全部刪除
      for (int i = 0; i <= m; i++) {
          dp[i][0] = i;
      }

      // 將word1轉換成word2的前j個字符
      for (int j = 0; j <= n; j++) {
          dp[0][j] = j;
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  // 不需要額外操作
                  dp[i][j] = dp[i - 1][j - 1];
              } else {
                  // 從插入(dp[i][j- 1] + 1)、刪除(dp[i - 1][j] + 1)、替換(dp[i - 1][j - 1] + 1)取最小的
                  dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
              }
          }
      }
      return dp[m][n];
  }
}

/**
 * 編輯距離
 * 
 * dp數組表示word1前i個字符轉換成word2前j個字符所需的最小操作次數
 * 如果word1[i - 1] == word2[j - 1]，則不需要額外操作
 * 否則從插入、刪除、替換三種操作中選擇最小的
 * **/