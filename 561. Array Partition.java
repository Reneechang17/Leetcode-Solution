// Easy
// Sorting
// Time:O(nlogn),Space:O(1)
// https://leetcode.cn/problems/array-partition/

import java.util.Arrays;

class Solution {
  public int arrayPairSum(int[] nums) {
      Arrays.sort(nums);
      int sum = 0;
      for (int i = 0; i < nums.length; i += 2) {
          // select the smaller one of each pair
          sum += nums[i];
      }
      return sum;
  }
}
