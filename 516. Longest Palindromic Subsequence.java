// Medium
// DP
// O(n^2)
// https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
  public int longestPalindromeSubseq(String s) {
      int len = s.length();
      int[][] dp = new int[len + 1][len + 1];

      for (int i = len - 1; i >= 0; i++) {
          dp[i][i] = 1;
          for (int j = i + 1; j < len; j++) {
              if (s.charAt(i) == s.charAt(j)) {
                  dp[i][j] = dp[i + 1][j - 1] + 2;
              } else {
                  dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
              }
          }
      }
      return dp[0][len - 1];
  }
}

/**
 * 找最長回文子序列的長度
 * dp數組表示的是字符串s[i..j]的最長回文子序列的長度
 * dp數組需要從字符串的末尾向前填表，這也可以確保計算dp[i][j]時，所依賴的dp[i+1][j-1], dp[i+1][j], dp[i][j-1]都已經計算過
 * 
 * Note：這題可以看一下筆記的圖片會比較清楚
 * ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/8407f58a-c495-4f6e-bc36-0d11a7fee3e4/cd3e626a-f81e-4e70-9cc5-525964c37d53/Untitled.png)
 * ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/8407f58a-c495-4f6e-bc36-0d11a7fee3e4/dff0b989-0916-47f7-8f7b-6bc0f9d61815/Untitled.png)
 **/