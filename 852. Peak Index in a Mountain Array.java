// Medium
// Binary Search
// O(logn)
// Similar: 162
// https://leetcode.cn/problems/peak-index-in-a-mountain-array/

class Solution {
  public int peakIndexInMountainArray(int[] arr) {
    int left = 0, right = arr.length - 1;

    while (left < right) {
      int mid = (left + right) >> 1;

      // 峰值會大於其左右兩側的值，如果當前mid比其右側的小，那我們可以往右邊搜索
      if (arr[mid] < arr[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}

/**
 * 找單調數值中的峰值，用二分查找。峰值的特點是比其左右兩邊的值都大
 **/