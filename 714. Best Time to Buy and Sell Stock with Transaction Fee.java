// Medium
// DP
// O(n)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

class Solution {
  public int maxProfit(int[] prices, int fee) {
      int[] dp = new int[2];
      dp[0] = -prices[0]; // 表示持有的狀態
      dp[1] = 0; // 表示賣出的狀態，同時支付手續費

      for (int i = 1; i <= prices.length; i++) {
          dp[0] = Math.max(dp[0], dp[1] - prices[i - 1]);
          dp[1] = Math.max(dp[1], dp[0] + prices[i - 1] - fee);
      }
      return dp[1];
  }
}

/**
 * 買賣股票的最佳時機含冷凍期
 * 本題限制：不能同時參與多筆交易，mean要賣掉才能再買入，每次交易後都會有一筆手續費需要支付
 * 
 * 這題的狀態相對於來說沒有那麼複雜
 * 只是每次賣出的時候都要記得扣除手續費
 **/