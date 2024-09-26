// Medium
// DP
// O(n* maxAmount * maxCoupons)
// https://leetcode.com/problems/maximize-total-tastiness-of-purchased-fruits/

class Solution {
  public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
    int n = price.length;
    int[][][] dp = new int[n + 1][maxAmount + 1][maxCoupons + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= maxAmount; j++) {
        for (int k = 0; k <= maxCoupons; k++) {
          dp[i][j][k] = Integer.MIN_VALUE;
        }
      }
    }

    dp[0][0][0] = 0;

    for (int i = 1; i <= n; i++) {
      int p = price[i - 1];
      int t = tastiness[i - 1];
      for (int j = 0; j <= maxAmount; j++) {
        for (int k = 0; k <= maxCoupons; k++) {
          // 1. 不買這個水果
          dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);

          // 2. 不用優惠券
          if (j >= p) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - p][k] + t);
          }
          // 3. 用優惠券
          if (k > 0 && j >= p / 2) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - p / 2][k - 1] + t);
          }
        }
      }
    }
    // 找出dp[n][maxAmount][maxCoupons]的最大值
    int res = 0;
    for (int j = 0; j <= maxAmount; j++) {
      for (int k = 0; k <= maxCoupons; k++) {
        res = Math.max(res, dp[n][j][k]);
      }
    }
    return res;
  }
}

/**
 * 最大化購買水果的美味值：在總價格不超過maxAmount的前提下，最大化購買水果的美味值，並且最多可以適用maxCoupons次優惠，使用優惠券可以減半價格
 * 
 * 這題是一個比較明顯的DP，有點類似於背包問題，在有限的條件下找極端值
 * 只不過多加一個條件是優惠券的使用
 * 這題可以用三位數組的dp，聽起來很難但是很好理解，dp[i][j][k]代表前i個水果，花費j價格，使用k次優惠券的最大美味值
 * 有三種狀態轉移方式 1. 不買當前這個水果 => dp[i][j][k] = dp[i-1][j][k]  
 * 2. 不用優惠券購買當前的水果 => dp[i][j][k] = dp[i-1][j-p][k] + t ， p表示當前水果的價格，t表示當前水果的美味值
 * 3. 使用優惠券購買當前的水果 => dp[i][j][k] = dp[i-1][j-p/2][k-1] + t
 * 
 * 最後在用嵌套的for循環找出dp[n][maxAmount][maxCoupons]的最大值即可（遍歷maxAmount和maxCoupons）
 **/