// Medium
// DP
// O(n)
// https://leetcode.com/problems/paint-house/

class Solution {
  public int minCost(int[][] costs) {
      if (costs.length == 0 || costs == null) return 0;

      int n = costs.length;
      for (int i = 1; i < n; i++) {
          costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
          costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
          costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
      }

      return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
  }
}

/**
 * 最小房屋塗色成本：需要給一排房子上色，每個房子可以用紅、藍、綠，每個顏色的成本不同，並且相鄰的兩個房子不能塗同一個顏色
 * 
 * 給定一個n x 3的成本矩陣，其costs[i][j]表示塗到第i個房子，且第i個房子塗j的顏色時的最小成本
 * 狀態轉移：第i個房子為某種顏色的總成本是前一個房子塗其他顏色的最小成本加上當前顏色的成本
 **/