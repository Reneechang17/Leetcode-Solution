// Medium
// DP
// O(n)
// https://leetcode.cn/problems/house-robber/

class Solution {
  public int rob(int[] nums) {
      // 打家劫舍，不能偷相鄰的 -> DP -> dp數組表示前i個房子能偷竊的錢
      // 對於當前房子，如果偷，狀態是i-2 + 當前nums[i]
      // 如果不偷當前的，狀態就是從i-1過來
      if (nums == null || nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];

      int[] dp = new int[nums.length + 1];
      dp[0] = nums[0];
      dp[1] = Math.max(dp[0], nums[1]); // 相當於選nums[0]和nums[1]中大的偷

      for (int i = 2; i < nums.length; i++) {
          dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return dp[nums.length - 1];
  }
}
