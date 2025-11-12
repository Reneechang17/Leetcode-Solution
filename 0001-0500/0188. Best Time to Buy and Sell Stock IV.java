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
        
        // dp arr to store the max profit at each transaction state
        int[] dp = new int[2 * k + 1];

        // initialize the odd state with -prices[0]
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 1) {
                    // update buy state: keep prev buy or buy at cur price
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    // update sell state: keep prev sell or sell at cur price
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }
        return dp[2 * k];
    }
}
