// Medium
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
  // since we need the max profit, we can use a variable to record the profit for each day
  // for ex, if day1~day3 can make max profit, the max profit can be (day3-day2)+(day2-day1)
  public int maxProfit(int[] prices) {
      int res = 0;
      for (int i = 1; i < prices.length; i++) {
          // if prices[i] - prices[i - 1] smaller than 0, we can ignore it
          res += Math.max(prices[i] - prices[i - 1], 0);
      }
      return res;
  }
}
