// Medium
// DP
// O(mn)
// Same: 1143
// https://leetcode.com/problems/uncrossed-lines/

class Solution {
  public int maxUncrossedLines(int[] nums1, int[] nums2) {
      int m = nums1.length, n = nums2.length;
      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              if (nums1[i - 1] == nums2[j - 1]) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
              } else {
                  dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
              }
          }
      }
      return dp[m][n];
  }
}

/**
 * 不相交的線
 * 解法和思路和1143最長公共子序列LCS幾乎一樣
 * 
 * 題目乍看之下可能會想不到DP，其實可以看作是一種特殊的LCS問題，要求在兩個數組中盡可能將出現的元素連接起來，並且不交叉
 * 本質上就是求兩個數組的最長公共子序列
 **/