// Medium
// DP
// O(n)
// Similar: 256
// https://leetcode.com/problems/house-robber-ii/

class Solution {
  public int rob(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];
      return Math.max(robAction(nums, 0, nums.length - 1), robAction(nums, 1, nums.length));
  }

  public int robAction(int[] nums, int start, int end) {
      int prev2 = 0, prev = 0, cur = 0;
      for (int i = start; i < end; i++) {
          prev = cur;
          cur = Math.max(prev, prev2 + nums[i]);
          prev2 = prev;
      }
      return cur;
  }
}

/**
 * 打家劫舍，看最多能偷多少錢，不能偷相鄰的
 * 這題有新的限制：房子圍成一個圈，最後一個和第一個挨著，不能同時搶頭或尾，只能考慮搶頭不搶尾 or 搶尾不搶頭
 * 
 * 在dp過程中，最大金額為不搶當前的（即prev）或是搶當前（即prev2+nums[i]）中較大的
 **/