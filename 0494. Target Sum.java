// Medium
// DP
// O(n / size)
// https://leetcode.com/problems/target-sum/

class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    if (Math.abs(target) > sum)
      return 0;
    if ((target + sum) % 2 == 1)
      return 0;

    int size = (target + sum) / 2;
    int[] dp = new int[size + 1];

    dp[0] = 1;

    for (int i = 0; i < nums.length; i++) {
      for (int j = size; j >= nums[i]; j--) {
        dp[j] += dp[j - nums[i]];
      }
    }
    return dp[size];
  }
}

/**
 * 給定一串非負整數數組的一個目標數，可以在任意一個整數前添加加號或是減號
 * 問：總共有多少種方法可以讓這些數字加總的和為目標數？
 * 
 * 可以看成A+B = sum (假設A表示m個正數1，B表示n個負數1)
 * => A+(-B) = target
 * => A+(-sum-A) = target
 * => 2A = target + sum
 * => A = (target + sum) / 2
 * 
 * sum是我們自己算的，target由題目給定
 * 
 * 假設我們算出A=4，表示五個位置中，有四個位置會是正數
 * 
 * dp[j] += dp[j - nums[i]];
 * [a, b, c, d, e]
 * 包包裡有四個位置是正數，方案有dp[4-a]+dp[4-b]+dp[4-c]+dp[4-d]+dp[4-e]種
 **/