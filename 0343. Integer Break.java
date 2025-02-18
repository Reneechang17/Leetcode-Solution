// Medium
// DP
// O(n^2)
// https://leetcode.com/problems/integer-break/

class Solution {
  public int integerBreak(int n) {
      int[] dp = new int[n + 1];
      dp[2] = 1;

      for (int i = 3; i <= n ; i++) {
          for (int j = 1; j <= i - j; j++) {
              dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
          }
      }
      return dp[n];
  }
}

/**
 * 整數拆分：將整數n分解為至少兩個正整數的和，求這些整數的最大乘積
 * 
 * 這裡可以用dp來求
 * 因為題目要求最少拆成兩個數，所以dp[2] 初始化為1，因為2只能拆分成1+1，乘積為1
 * dp的過程就從i=3開始，對於每一個i，都嘗試用一個j去拆分，所以j這裡的範圍為i-j
 * 對於每個j，有兩種拆分方式
 * 1. j * (i - j)：直接將i拆分為j & i-j，並計算乘積
 * 2. j * dp[i - j]：將i-j這部分繼續拆分找更大的乘積
 * **/