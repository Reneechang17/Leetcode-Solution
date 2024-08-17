// Medium
// DP
// O(n)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

class Solution {
  public int maxProfit(int[] prices) {
      int[] dp = new int[4];
      dp[0] = -prices[0];
      dp[1] = 0;

      for (int i = 1; i < prices.length; i++) {
          int tmp0 = dp[0];
          int tmp1 = dp[1];

          // 買入：前一天就買入 or 當天買入（前一天是冷凍期dp[3]或是前一天不持有dp[1]）
          dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i]);

          // 不持有且不在冷凍期：前一天賣出 or 前一天是冷凍期
          dp[1] = Math.max(dp[2], dp[3]);

          // 今天賣出：前一天是持有的
          dp[2] = tmp0 + prices[i];

          // 冷凍期：前一天一定是賣出
          dp[3] = tmp1;
      }
      // 不持有股票且不處於冷凍期、不持有股票處於冷凍期、當天就賣出股票中的最大值
      return Math.max(dp[3], Math.max(dp[1], dp[2]));
  }
}

/**
 * 買賣股票的最佳時機含冷凍期
 * 本題限制：不能同時參與多筆交易，mean要賣掉才能再買入，交易多少次都可以，但是賣出股票的隔天不能做交易（即有一天冷凍期）
 * 
 * 這題一樣可以用DP的思路
 * 考慮一天之中可能會有什麼狀態，以及這個狀態是怎麼推過來的
 * 1. 當天是持有的狀態：前一天就買入 or 當天買入（前一天可能是冷凍期或是前一天不持有）
 * 2. 當天是不持有並且不在冷凍期：前一天就賣掉 or 前一天是冷凍期
 * 3. 當天賣出：前一天就是持有的狀態
 * 4. 當天為冷凍期：那麼前一天一定是賣出的狀態（即不持有）
 * 
 * Note：需要有兩個變量來保存dp[0]和dp[1]
 **/