// Easy
// Sliding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-average-subarray-i/

class Solution {
  // For each step, calculate the sum of cur window and 
  // update the maxSum found
  public double findMaxAverage(int[] nums, int k) {
      // initialize the sum of the first window
      int sum = 0;
      for (int i = 0; i < k; i++) {
          sum += nums[i];
      }
      // initialize the max sum to the first window's sum
      int maxSum = sum;
      for (int i = k; i < nums.length; i++) {
          // update the window sum: add next element and remove 
          // the first element of prev window
          sum += nums[i] - nums[i - k];
          // update the maxSum
          maxSum = Math.max(maxSum, sum);
      }
      return (double) maxSum / k;
  }
}
