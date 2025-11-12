// Medium
// DP
// Time:O(n^2), Space:O(n^2)
// https://leetcode.cn/problems/triangle/

import java.util.*;

// This question can only use DP because it limit the options can choose for each layer
// we can only choose i or i+1 for next layer

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // the last line dp is the row of triangle
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        // update dp from last two line
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
