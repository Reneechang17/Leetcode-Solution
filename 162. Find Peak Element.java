// Medium
// Binary Search
// O(logn)
// https://leetcode.com/problems/find-peak-element/

class Solution {
  public int findPeakElement(int[] nums) {
      int left = 0, right = nums.length - 1;

      while (left < right) {
          int mid = (left + right) >> 1;

          // 如果中間值小於它右邊的值，峰值在右邊
          if (nums[mid] < nums[mid + 1]) {
              left = mid + 1;
          } else {
              right = mid; // 不然峰值就是在左邊或是mid上
          }
      }
      return left; // 最後left和right會收斂到同一個點，這就是峰值的位置
  }
}

/**
 * 數組中找峰值，可以發現峰值就是某一段單調的最大值，峰值會比他左右兩側的值都大 即nums[i] > nums[i - 1] && nums[i] > nums[i + 1]
 **/