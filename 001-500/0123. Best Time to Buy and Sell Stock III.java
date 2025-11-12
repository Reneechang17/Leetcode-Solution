// Hard
// DP
// Time:O(n),Space:O(1)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class Solution {
  // Use 4 variables to track two transactions:  
  // Update firstBuy and firstSell for the first transaction
  // Update secondBuy and secondSell for the second transaction  
  // Return secondSell as the maximum profit after two transactions
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
