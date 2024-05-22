// Medium
// Array, Two Pointers
// O(n)

class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 2)
      return nums.length;

    int i = 1;
    for (int j = 2; j < nums.length; j++) {
      // If the current element is not equal to the element at i-1,
      // it means it is not a duplicate of the last two elements in the processed part of the array
      if (nums[j] != nums[i - 1]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
