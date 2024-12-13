// Easy
// Math
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/missing-number/

import java.util.*;

class Solution {
  // Use the sum formula for the first n natural numbers: n * (n + 1) / 2
  // Calculate the expected sum and subtract the actual sum of the array
  // The difference gives the missing number
  public int missingNumber(int[] nums) {
      int n = nums.length;
      int expectedSum = n * (n + 1) / 2;
      int sum = 0;
      for (int x : nums) {
          sum += x;
      }
      return expectedSum - sum;
  }
}

class Solution2 {
  // Time: O(n), Space: O(n)
  public int missingNumber(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) set.add(nums[i]);
      for (int i = 0; i <= nums.length; i++) {
          if(!set.contains(i)) return i;
      }
      return -1;
  }
}
