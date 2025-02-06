// Medium
// Counting
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/

class Solution {
  // Check the descending points, if more than one -> false
  public boolean check(int[] nums) {
      int count = 0, n = nums.length;
      for (int i = 0; i < n; i++) {
          if (nums[i] > nums[(i + 1) % n]) {
              count++;
              if (count > 1) return false;
          }
      }
      return true;
  }
}
