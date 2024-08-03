// Easy
// DP
// O(n)
// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
  public int minCostClimbingStairs(int[] cost) {
      int len = cost.length;
      int[] dp = new int[len + 1];

      dp[0] = 0;
      dp[1] = 0; // You can either start from the step with index 0, or the step with index 1.

      for (int i = 2; i <= len; i++) {
          dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
      }
      return dp[len];
  }
}

/**
 * 最小花費的爬樓梯：給定一個整數數組cost，其中cost[i]是從樓梯的第i個台階向上爬需要支付的費用，一旦支付，可以選擇爬一個或是爬兩個
 * 當然也可以選擇在index0或是index1開始爬
 * 
 * 這題是經典的dp，首先可以明確dp[0]和dp[1]為0，因為我們可以從index0or1開始爬
 * dp數組的意義：爬到第i個台階的最少花費為dp[i]
 * 有兩個途徑可以得到dp[i]，一個是dp[i - 1]一個是dp[i - 2]
 * dp[i - 1]到dp[i]需要花費dp[i - 1] + cost[i - 1]
 * dp[i - 2]到dp[i]需要花費dp[i - 2] + cost[i - 2]
 * 從其中小的那個跳即可
 **/