// Medium
// Two Pointers
// Time:O(n^2),Space:O(1)
// https://leetcode.cn/problems/3sum-smaller/

import java.util.*;

class Solution {
  // Iterate each num as first element and calculate valid combinations
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum < target) {
          // all pair from left to right are valid
          count += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    return count;
  }
}
// 因为数组已经排序了，可以想成nums[left+1]~nums[right]的所有数和当前nums[i]&nums[left]
// 的组合也会满足sum<target, 所以right-left是所有有效组合的总数
