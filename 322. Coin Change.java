// Medium
// DP
// O(n * amount)
// https://leetcode.cn/problems/coin-change/

class Solution {
    // 找到最少硬币数量，使得硬币总和等于给定的amount，每个硬币的数量是无限的 -> 背包问题
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;

        // dp[j]表示凑出金额为j所需硬币的最少数量为dp[j]
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }

        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    // 可以選擇加coins[i]或是不加，因為我們要找最少硬幣數量，所以取其小的
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
