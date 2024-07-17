// Medium
// DP
// O(n^2)
// https://leetcode.com/problems/palindrome-partitioning-ii/

class Solution {
  public int minCut(String s) {
      int n = s.length();
      // dp數組表示字符串前i+1個字符的最小分割次數
      int[] dp = new int[n];
      // 判斷任意子串是否為回文
      boolean[][] isPalindrome = new boolean[n][n];

      // 初始化：最壞情況是每一個字符都要切一刀
      for (int i = 0; i < n; i++) {
          dp[i] = i;
      }
      for (int i = 0; i < n; i++) {
          for (int j = 0; j <= i; j++) {
              // 檢查s[j..i]是否為回文
              if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                  isPalindrome[j][i] = true;
                  if (j == 0) {
                      dp[i] = 0; // 如果從頭到i是回文，不需要切割
                  } else {
                      dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                  }
              }
          }
      }
      return dp[n - 1];
  }
}

/**
 * 將字符串分割成若干個回文子串，求最少可以切割幾次
 * 
 * 思路：用dp，dp數組表示字符串前i+1個字符的最小分割次數
 * 另外開一個boolean數組來檢查子串s[i...j]是否為回文子串
 * 
 * 檢查s[j...i]是否為回文串時，需要加上isPalindrome[j + 1][i - 1]條件
 * 這個意思是我們假設更小的子串s[j+1...i-1]也是回文串的，那麼現在s[j...i]也是（狀態轉移）
 * 
 * 如果子串從頭到i都是回文，那麼就不用切割了，dp[i] = 0
 * ⬆️也就是s[0...i]都是回文，那麼就是j=0的時候
 **/