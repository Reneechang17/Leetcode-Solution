// Medium
// DP
// O(n * amount)
// https://leetcode.com/problems/coin-change-ii/

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

/**
 * 問有多少種組合方式可以湊出總金額amount
 * 求的是組合表示不強調元素間的順序 ex 221 122算一個
 * 
 * 外層遍歷物品，即錢幣，內層遍歷背包容量，即金額總額: 求組合（不管順序）
 * 返回dp[amount]指用多少coins湊到這個amount有dp[amount]種方法
 * 
 * 補充：如果求排序的話（管順序）就外背包，內物品 ex. 377組合總和（題目看似求組合實際求排序）
 **/