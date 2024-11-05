// Medium
// Array, Two Pointers
// O(n)
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
  // no extra space so we need to operate on the nums
  // can use two pointers, i start from the second element, and j start from the third one
  // and we need to compare the j and i - 1, if they are the same, means they appear over twice
  public int removeDuplicates(int[] nums) {
      // basecase: if only 2 element, and pass it
      // since even they are same, still accept
      if (nums.length <= 2) {
          return nums.length;
      }

      int i = 1; 
      for (int j = 2; j < nums.length; j++) {
          if (nums[j] != nums[i - 1]) {
              // then we paste j to i's next, so need to move the i first
              i++;
              nums[i] = nums[j];
          }
      }
      return i + 1;
  }
}
