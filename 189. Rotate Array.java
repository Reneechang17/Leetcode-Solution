// Medium
// Array
// O(n)

class Solution {
  public void rotate(int[] nums, int k) {
      int n = nums.length;
      k = k % n;
      reverse(nums, 0, n - 1); // reverse the whole nums
      reverse(nums, 0, k - 1); // reverse first k
      reverse(nums, k, n - 1); // reverse the last n - k
  }
  public void reverse(int[] nums, int i, int j){
      for(; i < j; i++, j--){
          int t = nums[i];
          nums[i] = nums[j];
          nums[j] = t;
      }
  }
}
