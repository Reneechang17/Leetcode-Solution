// Medium
// DP
// O(n* maxAmount * maxCoupons)
// https://leetcode.cn/problems/maximize-total-tastiness-of-purchased-fruits/

class Solution {
  // 三維dp[i][j][k]：表示前i個水果，花費j價格，使用k次優惠券的最大美味值
  // 狀態1：不買當前水果 -> dp[i][j][k] = dp[i - 1][j][k]
  // 2：買當前不用優惠券 -> dp[i][j][k] = dp[i - 1][j - p][k] + t
  // 3：買當前且用優惠券 -> dp[i][j][k] = dp[i - 1][j - p / 2][k - 1] + t
  public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
      int n = price.length;
      int[][][] dp = new int[n + 1][maxAmount + 1][maxCoupons + 1];

      for(int i = 0; i <= n; i++) {
          for(int j = 0; j <= maxAmount; j++) {
              for(int k = 0; k <= maxCoupons; k++) {
                  dp[i][j][k] = Integer.MIN_VALUE;                
              }
          }
      }
      dp[0][0][0] = 0;

      for(int i = 1; i <= n; i++) {
          int p = price[i - 1];
          int t = tastiness[i - 1];

          for(int j = 0; j <= maxAmount; j++) {
              for(int k = 0; k <= maxCoupons; k++) {
                  dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);

                  if(j >= p) {
                      dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - p][k] + t);
                  }

                  if(k > 0 && j >= p / 2) {
                      dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - p / 2][k - 1] + t);
                  }
              }
          }
      }

      int res = 0;
      for(int j = 0; j <= maxAmount; j++) {
          for(int k = 0; k <= maxCoupons; k++) {
              res = Math.max(res, dp[n][j][k]);
          }
      }
      return res;
  }
}
