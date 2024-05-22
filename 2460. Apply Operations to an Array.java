// Easy
// Array, Two Pointers
// O(n)

class Solution {
  public int[] applyOperations(int[] nums) {
    // Step1: first do the operation on i && i + 1
    // Note: iterate only until the second last element to avoid index out of bounds
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1] && nums[i] != 0) {
        nums[i] *= 2;
        nums[i + 1] = 0;
      }
    }
    // Step 2: move all zeros to the end of the array
    int insertPos = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[insertPos++] = num;
      }
    }

    // fill the remaining positions in the array with zeros
    while (insertPos < nums.length) {
      nums[insertPos++] = 0;
    }
    return nums;
  }
}
