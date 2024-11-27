// Easy
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/

class Solution {
  // common idea: buy stock with low price, and sell it with high price
  public int maxProfit(int[] prices) {
      int low = Integer.MAX_VALUE;
      int res = 0;
      for (int i = 0; i < prices.length; i++) {
          low = Math.min(low, prices[i]);
          res = Math.max(res, prices[i] - low);
      }
      return res;
  }
}
