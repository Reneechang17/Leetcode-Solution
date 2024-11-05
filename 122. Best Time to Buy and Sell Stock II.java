// Medium
// Greedy
// O(n)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
  // since we only need the max profit, so we can use a variable to keep record the profit
  // for each day, for example, if the day1~day3 can make max profit
  // the max profit can be (day3-day2)+(day2-day1)
  public int maxProfit(int[] prices) {
      int res = 0;
      for (int i = 1; i < prices.length; i++) {
          res += Math.max(prices[i] - prices[i - 1], 0);
      }
      return res;
  }
}
