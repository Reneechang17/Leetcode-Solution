// Hard
// DP
// Time:O(n * k), Space:O(k)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/

class Solution {
    // Use DP to track max profit for each transaction state (buy/sell)
    // Odd states represent buying, even states represent selling
    // Iterate prices, update each state based on previous states
    // Result is stored in the last sell state (dp[2 * k])
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        int[] dp = new int[2 * k + 1];
        // initialize the odd state -> buying the stock
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 1) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        } 
        return dp[2 * k];
    }
}

/**
 * 買賣股票的最佳時機III
 * 本題限制：最少要完成k次交易，不能同時參與多筆交易，mean要賣掉才能再買入
 * 
 * 這題可以用123題的思路
 * 一天可能的狀態有以下五種
 * 1. 沒有狀態（沒有操作）
 * 2. 第一次買入股票
 * 3. 第一次賣出股票
 * 4. 第二次買入股票
 * 5. 第二次賣出股票 ...
 * 可以看出奇數次數都是買入，偶數次數都是賣出
 **/
