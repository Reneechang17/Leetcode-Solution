// Easy
// Binary Search
// Time: O(logn), Space: O(1)
// https://leetcode.cn/problems/search-insert-position/

class Solution {
    //  The left pointer will stop at the target position if the target exists in the arr;
    // if target is not in the arr, the left pointer will stop at the position where the target should be inserted
  // since right = mid - 1, left will always point to the next possible position
  public int searchInsert(int[] nums, int target) {
      int left = 0, right = nums.length - 1;
      while (left <= right) {
          int mid = (left + right) >> 1;
          if (nums[mid] < target) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return left;
  }
}
