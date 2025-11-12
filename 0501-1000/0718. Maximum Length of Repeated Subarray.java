// Medium
// DP
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/

class Solution {
    // dp[i][j]: the longest common subarray length between A[0..i-1] and B[0..j-1]
    // If A[i-1]==B[j-1], dp[i][j]=dp[i-1][j-1]+1, else dp[i][j]=0
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
