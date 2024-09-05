// Medium
// Binary search
// O(logn)~O(n)
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

class Solution {
  public boolean search(int[] nums, int target) {
      int left = 0, right = nums.length - 1;

      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] == target) return true;

          if (nums[left] == nums[mid]) {
              left++;
          } else if (nums[left] <= nums[mid]) {
              if (nums[left] <= target && target < nums[mid]) {
                  right = mid - 1;
              } else {
                  left = mid + 1;
              }
          } else {
              if (nums[mid] < target && target <= nums[right]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
          }
      }
      return false;
  }
}

/**
 * 33題相似，不同之處在於數組中可能會有重複的元素
 * 重複元素會導致更難確定哪一半有序以及旋轉點
 * 但是仍然可以用二分查找，關鍵在於遇到無法判斷的情況時，將左指針向右移動一位
 * 即當nums[left] == nums[mid]， 且nums[mid] != target時，無法判斷哪部分是有序的，可以通過left++來縮小範圍
 **/