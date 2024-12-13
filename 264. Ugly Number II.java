// Medium
// DP, Two Pointers
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/ugly-number-ii/

class Solution {
  // Use DP and three pointers to generate the ugly numbers
  // Maintain a DP arr where dp[i] is the i-th unly number
  // For each step, calculate the next candidates(2*dp[2], 3*dp[3], 5*dp[5]),
  // pick the smallest as the next ugly number, and move the corresponding pointer
  public int nthUglyNumber(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1; // the first ugly num is 1
      int p2 = 0, p3 = 0, p5 = 0; // initialize three pointers
      int f2 = 2, f3 = 3, f5= 5; // initialize three factors

      for (int i = 1; i < n; i++) {
          int min = Math.min(Math.min(f2, f3), f5);
          dp[i] = min;
          // update the corresponding pointer(first) and factor
          if (min == f2) f2 = 2 * dp[++p2];
          if (min == f3) f3 = 3 * dp[++p3];
          if (min == f5) f5 = 5 * dp[++p5];
      }
      return dp[n - 1];
  }
}
