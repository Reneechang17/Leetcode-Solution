// Easy
// Binary Search
// Time: O(logn), Space: O(1)
// https://leetcode.cn/problems/search-insert-position/

class Solution {
  // 最终的插入位置是left:循环结束时,left表示目标值的插入位置
  // 如果目标值已经存在, left会停在目标值位置; 如果不存在, left会停在应该插入的位置
  // 因为right=mid-1, 确保left总是指向下一个可能的位置
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
