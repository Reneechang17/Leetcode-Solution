// Medium
// Sliding Window
// O(n)
// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

class Solution {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
      int count = 0;
      int targetSum = k * threshold;
      int curSum = 0;

      for (int i = 0; i < k; i++) {
          curSum += arr[i];
      }

      if (curSum >= targetSum) {
          count++;
      }

      for (int i = k; i < arr.length; i++) {
          curSum += arr[i] - arr[i - k];
          if (curSum >= targetSum) {
              count++;
          }
      }
      return count;
  }
}

/**
 * 大小為k且平均值大於等於threshold的子數組數量：相當於找到所有長度為k的子數組，並且這些子數組的和大於等於k*threshold
 * 
 * 思路：這題是在數組上找所有可能，其實可以想到滑動窗口來計算所有長度為k的子數組的和
 * 可以先計算第一個窗口的和，然後每次滑動窗口的時候，用當前窗口的和減去最左邊的元素（即要被移除窗口的元素），加上新加入窗口的元素，就可以得到下一個窗口的和
 **/