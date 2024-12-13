// Medium
// DP
// Time:O(n * amount), Space:O(amount)
// https://leetcode.cn/problems/coin-change/

class Solution {
    // Use DP, dp[j] is the min number of coins needed to form the amount j
    // Initialize dp arr with a large impossible value
    // For each coin, iterate amount from coin value to target amount:
    //   - If the cur amount is valid(j - coin), update dp[j]
    //     we have two choices: 1. exclude/include the cur coin
    // After filling the dp arr, return dp[amount] if reachabke, otherwise -1 
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
