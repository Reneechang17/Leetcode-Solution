// Easy
// Array, Two Pointers
// O(n)
// https://leetcode.com/problems/move-zeroes/

class Solution {
  public void moveZeroes(int[] nums) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      // we can fill the non-zero first
      if (nums[j] != 0) {
        nums[i] = nums[j];
        // then add the zero at the end
        if (i != j) {
          nums[j] = 0;
        }
        i++;
      }
    }
  }
}

/**
 * 思路：
 * j指針遍歷數組，先填入非0的，最後再把0填入
 **/