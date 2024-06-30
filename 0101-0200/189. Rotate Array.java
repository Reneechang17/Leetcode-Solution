// Medium
// Array
// O(n)
// https://leetcode.com/problems/rotate-array/

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

/**
 * 思路：
 * 1. k先對數組的長度取模，得到實際旋轉的步數
 * 2. 反轉整個數組
 * 3. 反轉前k個
 * 4. 反轉剩下的，即n-k
 **/