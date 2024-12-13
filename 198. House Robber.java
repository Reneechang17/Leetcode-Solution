// Medium
// DP
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/house-robber/

class Solution {
  // dp: means the max money can rob from 0 to i
  // if rob the ith house, the max is dp[i - 2] + nums[i]
  // if not rob the ith house, the max is dp[i - 1](from prev)
  public int rob(int[] nums) {
      // basecase: if (nums.length == 0 || nums == null) return 0;
      if (nums.length == 1) return nums[0];
      int[] dp = new int[nums.length + 1];
      dp[0] = nums[0];
      dp[1] = Math.max(dp[0], nums[1]);// rob cur or prev(dp[0])
      
      for (int i = 2; i < nums.length; i++) {
          dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return dp[nums.length - 1]; // from 0 to n-1
  }
}
