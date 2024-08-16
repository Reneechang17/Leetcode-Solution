// Hard
// DP
// O(n)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class Solution {
  public int maxProfit(int[] prices) {
      int firstBuy = Integer.MIN_VALUE, firstSell = 0;
      int secondBuy = Integer.MIN_VALUE, secondSell = 0;

      for (int price : prices) {
          firstBuy = Math.max(firstBuy, -price);
          firstSell = Math.max(firstSell, firstBuy + price);
          secondBuy = Math.max(secondBuy, firstSell - price);
          secondSell = Math.max(secondSell, secondBuy + price);
      }
      return secondSell;
  }
}

/**
 * 買賣股票的最佳時機III
 * 本題限制：最少要完成兩次交易，不能同時參與多筆交易，mean要賣掉才能再買入
 * 
 * 因為一定要完成兩次交易，所以會有四個狀態，分別是第一次買入、第一次賣出、第二次買入、第二次賣出
 * 可以用四個變量來紀錄：
 * 1. firstBuy：第一次買入可以獲得的最大利益，實際上就是一個負值，就是買入股票的錢
 * 2. firstSell：第一次賣出股票，也就是第一次買入加上這次買股票賺入的price
 * 3. secondBuy：第二次買入，也就是在第一次賣出上減去這次買入股票的價錢
 * 4. secondSell：第二次賣出，也就是第二次買入加上這次買股票賺入的price
 * 
 * 最後返回secondSell後的錢
 **/