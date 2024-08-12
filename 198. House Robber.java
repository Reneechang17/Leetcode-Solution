// Medium
// DP
// O(n)
// https://leetcode.com/problems/house-robber/

class Solution {
  public int rob(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];

      int[] dp = new int[nums.length + 1];
      dp[0] = nums[0];
      dp[1] = Math.max(dp[0], nums[1]);

      for (int i = 2; i < nums.length; i++) {
          dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return dp[nums.length - 1];
  }
}

/**
 * 打家劫舍，看最多能偷多少錢，不能偷相鄰的
 * 
 * 可以用dp來做，dp數組表示前i個房子能夠偷竊的金額
 * 對於遍歷到的第i個房子，可以選擇偷或是不偷，如果偷的話，他前一個狀態是i-2來的，加上當前nums[i]
 * 如果不偷當前i，那可以考慮偷i-1的（只是考慮，也可以不偷）
 * 
 * basecase：如果nums為空或是沒有東西，直接返回0
 * 如果只有一個，直接返回nums[0]
 * 
 * 初始化dp數組，dp[0]直接等於第一個，dp[1]則是取前一個或是nums[1]中大的（這不是說兩個都偷，而是選nums[0]&nums[1]中大的偷
 **/