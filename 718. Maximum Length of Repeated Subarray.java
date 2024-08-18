// Medium
// DP
// O(mn)
// Similar: 1143
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

class Solution {
  public int findLength(int[] nums1, int[] nums2) {
      int res = 0;
      int m = nums1.length + 1, n = nums2.length + 1;
      int[][] dp = new int[m][n];

      for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
              if (nums1[i - 1] == nums2[j - 1]) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
                  res = Math.max(res, dp[i][j]);
              }
          }
      }
      return res;
  }
}

/**
 * 找最長公共（重複）子數組
 * 
 * 經典解法為DP，dp數組表示的是以nums[i - 1]和nums[j - 1]結尾的最長公共子數組的長度
 **/