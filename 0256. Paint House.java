// Medium
// DP
// O(n)
// https://leetcode.cn/problems/paint-house/

class Solution {
  public int minCost(int[][] costs) {
      // dp -> costs[i][j]表示第i間房子塗j顏色時的最小成本
      // 狀態轉移：第i間房子為某種顏色的成本時前一個房子塗其他顏色時的最小成本加上當前顏色的成本
      if (costs.length == 0 || costs == null) return 0;
      int n = costs.length;

      // i = 0時，不需要考慮前一個房子的情況，因為是給定的
      for (int i = 1; i < n; i++) {
          costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
          costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
          costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
      }
      return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
  }
}
