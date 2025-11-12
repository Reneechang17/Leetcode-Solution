// Medium
// DP
// Time:O(n^2), Space:O(n)
// https://leetcode.cn/problems/largest-divisible-subset/

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, maxSize = 0, maxIndex = 0;

        int[] dp = new int[n]; // dp[i]是以nums[i]结尾的最大整除子集长度
        int[] parent = new int[n]; // 记录子节点来回溯子集

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1); // 父节点为-1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        Collections.reverse(res);
        return res;
    }
}

/**
 * 如果a可以被b整除，那b一定是a之前的数（在排序后）
 * 排序后为DP问题，假设dp[i]是包含nums[i]的最大可整除子集的大小，对于每个i，要找到nums[j]（其中j<i）并检查nums[i]%nums[j]==0，如果成立则更新dp[i]=dp[j]+1：表示如果nums[i]可被nums[j]整除，那nums[i]可以加到以nums[j]为结尾的最大可整除子集中
 * 在此过程中，记录父节点来追溯子集
 */
