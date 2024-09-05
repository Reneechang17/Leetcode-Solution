// Medium
// Binary Search
// O(logn
// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
  public int search(int[] nums, int target) {
      int left = 0, right = nums.length - 1;

      while (left <= right) {
          int mid = left + (right - left) / 2;

          if (nums[mid] == target) {
              return mid;
          }

          if (nums[left] <= nums[mid]) {
              if (target >= nums[left] && target < nums[mid]) {
                  right = mid - 1;
              } else {
                  left = mid + 1;
              }
          } else {
              if (target > nums[mid] && target <= nums[right]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
          }
      }
      return -1;
  }
}

/**
 * 在旋轉排序數組中搜索：給定一個整數數組nums，按升序排序，並且在某個點上進行了旋轉
 * 例如，原數組nums = [0,1,2,4,5,6,7]可能變為[4,5,6,7,0,1,2]
 * 我們可以觀察到不管數組是怎麼排序以及怎麼旋轉的，都會有至少一半的數是有序的
 * 
 * 思路：二分查找
 * 關鍵在於確定有序的一半，可能是nums[left]到nums[mid]有序，也有可能是nums[mid]到nums[right]有序
 **/