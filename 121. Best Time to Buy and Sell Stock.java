// Easy
// Array, Greedy
// O(n)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/

class Solution {
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

/**
 * 買賣股票的最佳時機I
 * 
 * 思路：可以找到最左邊的最低價格，遍歷找最大的差值，可以賺最多
 **/
