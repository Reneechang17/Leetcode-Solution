// Medium
// DP
// O(n)
// Similar: 322 Coin Change
// https://leetcode.com/problems/perfect-squares/

class Solution {
  public int numSquares(int n) {
      int max = Integer.MAX_VALUE;
      int[] dp = new int[n + 1];

      for (int j = 0; j <= n; j++) {
          dp[j] = max;
      }

      dp[0] = 0;
      for (int i = 1; i * i <= n; i++) {
          for (int j = i * i; j <= n; j++) {
              if (dp[j - i * i] != max) {
                  dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
              }
          }
      }
      return dp[n];
  }
}

/**
 * 找出最少數量的完全平方數，它們的和等於給定的整數n
 * 
 * 外層遍歷所有可能的完全平方數的根，從1開始到sqrt(n)，內層循環從當前完全平方數開始直到n
 **/