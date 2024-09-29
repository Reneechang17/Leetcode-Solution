// Medium
// DP
// O(n * amount)
// https://leetcode.cn/problems/coin-change/

class Solution {
  public int coinChange(int[] coins, int amount) {
      int max = Integer.MAX_VALUE;
      int[] dp = new int[amount + 1];

      for (int j = 0; j < dp.length; j++) {
          dp[j] = max;
      }

      dp[0] = 0;

      for (int i = 0; i < coins.length; i++) {
          for (int j = coins[i]; j <= amount; j++) {
              if (dp[j - coins[i]] != max) {
                  dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
              }
          }
      }
      return dp[amount] == max ? -1 : dp[amount];
  }
}

/**
 * 找最少硬幣數量，使得硬幣總和等於給定的總金額amount，並且每個硬幣的數量都是無限的 =>背包問題
 * 
 * dp[j]表示湊出金額為j的所需硬幣最少個數為dp[j]
 * 狀態轉移：可以選擇加coins[i]或是不加，因為我們要找最少硬幣數量，所以取其小的
 * 
 * Note：這題的dp[j]需要先初始化為最大值（Integer.MAX_VALUE）
 * 否則在min(dp[j - coins[i]] + 1, dp[j])比較過程中會被初始值覆蓋
 **/