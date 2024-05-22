// Easy
// Array, Two Pointers
// O(n)

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
