// Medium
// Kadane Algorithm
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-sum-circular-subarray/

class Solution {
    // Kadane Algorithm -> find the max subarray sum in O(n)
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0], maxSum = nums[0], minSum = nums[0], curMax = nums[0], curMin = nums[0];
        // calculate the total sum of arr
        // calculate the max and min subarray sum using Kadane
        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            // max subarray sum
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);
            // min subarray sum
            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(minSum, curMin);
        }
        // edge: if all numbers are negative, return the max sum found
        if (totalSum == minSum) {
            return maxSum;
        }

        // return the max of normal max sum and the totalSum - minSum
        return Math.max(maxSum, totalSum - minSum);
    }
}

/**
 * 可以考虑两种情况：
 * 1. 普通最大子数组和
 * 2. 环形子数组最大和：如果子数组跨越数组的尾部和头部，可以利用最小子数组和来找到最大子数组
 * 假设我们计算了最小的子数组和，那么总和减去最小子数组和就等于跨越数组头尾的最大子数组和
 */
