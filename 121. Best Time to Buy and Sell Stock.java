// Easy
// Array, Greedy
// O(n)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/

class Solution {
  // goal: buy in min price, then sell it in max price -> make the max profit
  public int maxProfit(int[] prices) {
      int low = Integer.MAX_VALUE;
      int res = 0;

      for (int i = 0; i < prices.length; i++) {
          low = Math.min(prices[i], low);
          res = Math.max(prices[i] - low, res);
      }

      return res;
  }
}
