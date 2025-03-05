// Medium
// DP
// Time:O(n^2),Space:O(n)
// https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/

import java.util.Arrays;

class Solution {
    public int twoEggDrop(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] = Math.min(dp[i], Math.max(k - 1, dp[i - k]) + 1);
            }
        }
        return dp[n];
    }
}

// dp[i]表示i层楼的建筑需要的最小操作次数，每次丢下鸡蛋有两种情况
// 1. 如果鸡蛋碎了，代表范围在[0,k-1]，因此只能依次在第1,2,..,k-1层扔第二颗鸡蛋找到答案，需要k-1次
// 2. 如果鸡蛋没碎，代表范围在[k,i]，此时剩下两颗鸡蛋，等同于一栋i-k层的建筑子问题，需要dp[i-k]次
