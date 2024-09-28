// Medium
// Binary Search
// O(logn)
// Similar: 162
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
  public int peakIndexInMountainArray(int[] arr) {
    int left = 0, right = arr.length - 1;

    while (left < right) {
      int mid = (left + right) >> 1;

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
 * 和162的找峰值是差不多的，題目甚至有直說他單調的變化，我們找的就是這個變化的轉折點，這個點會比他左右兩側都小，就是峰值
 **/