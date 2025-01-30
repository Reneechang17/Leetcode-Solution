// Easy
// Iteration
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-difference-between-increasing-elements/

class Solution {
  // Track the min value while iterating the arr
  // If the cur element is bigger than the min, update the max diff
  //   - update the min value if a smaller element is found
  public int maximumDifference(int[] nums) {
      int minVal = nums[0], maxDiff = -1;
      for (int i = 1; i < nums.length; i++) {
          if (nums[i] > minVal) {
              maxDiff = Math.max(maxDiff, nums[i] - minVal);
          }
          // update the minVal
          minVal = Math.min(minVal, nums[i]);
      }
      return maxDiff;
  }
}
