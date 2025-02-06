// Hard
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/

class Solution {
  public int findMin(int[] nums) {
      int left = 0, right = nums.length - 1;
      while (left < right) {
          int mid = (left + right) >> 1;
          if (nums[mid] > nums[right]) {
              left = mid + 1;
          } else if (nums[mid] < nums[right]) {
              right = mid;
          } else {
              right--;
          }
      }
      return nums[left];
  }
}

// 和153的不同：包含重复元素，这样当nums[mid]==nums[right]时无法判断哪边有序
// 这时候可以直接把right去掉，因为nums[right]不可能是最小值（即使它是，也会在right-1范围内）
