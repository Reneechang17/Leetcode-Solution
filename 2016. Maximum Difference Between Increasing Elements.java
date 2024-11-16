// Easy
// Prefix Min
// O(n)
// https://leetcode.cn/problems/maximum-difference-between-increasing-elements/

class Solution {
  // 前缀最小值Premin
  public int maximumDifference(int[] nums) {
    int res = -1, preMin = nums[0];

    // check if the nums[i] > premin, if so, then we calculate the diff of nums[i]
    // and premin
    // if not, we update the premin with nums[i]
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > preMin) {
        res = Math.max(res, nums[i] - preMin);
      } else {
        preMin = nums[i];
      }
    }
    return res;
  }
}
