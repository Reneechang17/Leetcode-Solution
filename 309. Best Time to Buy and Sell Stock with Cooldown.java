// Medium
// DP
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/

class Solution {
  // Use DP with four states to track the maximum profit:
  //  - dp[0]: Holding a stock: either bought today or carried from a prev day
  //  - dp[1]: Not holding a stock and not in the cooldown period
  //  - dp[2]: Selling a stock today
  //  - dp[3]: In the cooldown period (yesterday was a sell)
  public int maxProfit(int[] prices) {
      int[] dp = new int[4];
      dp[0] = -prices[0]; // holding a stock
      dp[1] = 0; // not holding stock & not in cooldown

      for (int i = 1; i < prices.length; i++) {
          // store the previous day's state
          int temp0 = dp[0];
          int temp1 = dp[1];

          // update holding state: Keep holding or buy today 
          //  - either from cooldown or non-holding state
          dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i]);

          // update non-holding & non-cooldown state
          //  - either remain here or come from cooldown
          dp[1] = Math.max(dp[2], dp[3]);

          // update selling state: Only possible if previously holding a stock
          dp[2] = temp0 + prices[i];

          // update cooldown state: Only possible if stock was sold yesterday
          dp[3] = temp1;
      }
      // return the max profit from non-holding states
      return Math.max(dp[3], Math.max(dp[1], dp[2]));
  }
}
