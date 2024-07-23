// Medium
// Greedy
// O(n)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
  public int maxProfit(int[] prices) {
      int res = 0;
      for (int i = 1; i < prices.length; i++) {
          res += Math.max(prices[i] - prices[i - 1], 0);
      }
      return res;
  }
}

/**
 * 買賣股票的最佳時機II
 * 本題限制：只有一支股票、只有買賣操作、買賣可以在同一天
 * 
 * 思路：選一個低價的買入，高價的賣出，不斷循環
 * 假設我們第一天買入，第三天賣出，可以分解成day3-day2 + day2-day1
 * 
 * 因為本題只要給出最終利潤，所以不需要紀錄其區間
 * 局部最優：收集每天正利潤
 * 全局最優：最大利潤
 **/