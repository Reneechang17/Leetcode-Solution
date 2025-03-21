// Medium
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
  // Only need to find the max profit, for example: 
  //   - if day1~day3 can make max profit, the max profit can be (day3-day2)+(day2-day1)
  // We can only collect the pos profit, ignore neg since it cannot form the max profit
  public int maxProfit(int[] prices) {
      int res = 0;
      for (int i = 1; i < prices.length; i++) {
          res += Math.max(0, prices[i] - prices[i - 1]);
      }
      return res;
  }
}
