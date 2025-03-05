// Medium
// DP
// Time:O(n^2),Space:O(n)
// https://leetcode.cn/problems/longest-increasing-subsequence/

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length, res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
/**
 * 对于每个位置i，需要知道在i之前的哪个位置可以形成更长的递增子序列=>问题的解依赖于之前的状态=>DP
 * dp数组表示以nums[i]结尾的最长递增子序列的长度
 * 对于每个i，遍历i前面的元素j，如果nums[j]>nums[i]，则dp[i]=Math.max(dp[i], dp[j+1])，
 * 即在位置j的最长递增子序列的基础上加上nums[i]
 */
