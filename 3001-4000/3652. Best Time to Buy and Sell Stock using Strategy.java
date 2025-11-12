// Medium
// Sliding window
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-using-strategy/

// OK, this is a very tricky question and somehow we need to first understand what it talks about.
// It actually wants to ask: based on the original profit, how could we have to get the maxProfit
// (delta), and it gives us the limit k, which we could see as a window(yes, sliding window).
// If we say the sliding window as [0, k-1], we have to handle the change when[i-k, i-1] to [i-k+1, i]
// where we have to update delta for each case as well as update the maxProfit.
// For details, see code.

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long profit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            profit += prices[i] * strategy[i];
        }

        long max = profit;
        long additional = 0;
        for (int i = 0; i < k; i++) {
            additional -= prices[i] * strategy[i];
            if (i >= k / 2) {
                additional += prices[i];
            }
        }
        max = Math.max(max, profit + additional);
        for (int i = k; i < n; i++) {
            additional += prices[i - k] * strategy[i - k];
            additional -= prices[i - k / 2];
            additional += prices[i] - prices[i] * strategy[i];
            max = Math.max(max, profit + additional);
        }
        return max;
    }
}
