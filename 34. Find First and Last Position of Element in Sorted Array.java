// Medium
// Array, Binary Search
// O(logn)
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
  public int[] searchRange(int[] nums, int target) {
      int[] res = {-1, -1};
      res[0] = findFirst(nums, target);
      res[1] = findLast(nums, target);
      return res;
  }

  private int findFirst(int[] nums, int target) {
      int index = -1;
      int left = 0, right = nums.length - 1;
      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] >= target) {
              if (nums[mid] == target) index = mid;
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      return index;
  }

  private int findLast(int[] nums, int target) {
      int index = -1;
      int left = 0, right = nums.length - 1;
      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] <= target) {
              if (nums[mid] == target) index = mid;
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return index;
  }
}

/**
 * 在已經排序的數組中找給定目標值的起始位置和結束位置的問題
 * 如果數組不存在目標值，返回[-1, -1]
 * 需要實現時間複雜度O(logn)的算法來解決此問題
 * 
 * 既然要logn，可以聯想到二分查找，直接用兩次二分來找左邊界和右邊界即可
 **/