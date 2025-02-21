// Medium
// DP
// Time:O(n^2), Space:O(n^2)
// https://leetcode.cn/problems/triangle/

import java.util.*;

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[][] dp = new int[n][n];
      // from bottom, the last line dp is the last row of triangle
      for (int i = 0; i < n; i++) {
          dp[n - 1][i] = triangle.get(n - 1).get(i);
      }
      // update dp arr start from last two row 
      for (int i = n - 2; i >= 0; i--) {
          for (int j = 0; j <= i; j++) {
              dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
          }
      }
      return dp[0][0];
  }
}

// 从顶点出发，每次往下走，只能选择其左下角或右下角元素
// dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])
