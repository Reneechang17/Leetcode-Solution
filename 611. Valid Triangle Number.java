// Medium
// Two Pointers
// O(n log n), 最壞 O(n^2)
// https://leetcode.com/problems/valid-triangle-number/

import java.util.Arrays;

class Solution {
  public int triangleNumber(int[] nums) {
      int count = 0;
      Arrays.sort(nums);

      for (int k = nums.length - 1; k >= 2; k--) {
          int i = 0, j = k - 1;
          while (i < j) {
              if (nums[i] + nums[j] > nums[k]) {
                  count += j - i; // 如果满足，那i-j的组合都成立
                  j--;
              } else {
                  i++;
              }
          }
      }
      return count;
  }
}

/**
 * 有效的三角形個數：要求在給定的數組中，找滿足三角形條件的三個邊的組合個數
 * 三角形的三個邊需要滿足條件：a + b > c，其中 a ≤ b ≤ c
 * 
 * 思路：這題可能會有點難想，但是透過三角形邊的定律我們可以嘗試固定一個邊，找另外兩個相加大於固定邊的組合
 * 可以通過雙指針完成，首先先對數組排序，對於每個固定的最大邊k，用雙指針找哪個區間的和大於nums[k] => nums[i] + nums[j] > nums[k]
 * 滿足這個條件時，表示i-j這段的所有組合都是滿足的，所以count += j - i，然後縮小j，直到不滿足條件，縮小i
 **/