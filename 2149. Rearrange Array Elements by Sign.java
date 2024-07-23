// Medium
// Greedy
// O(n)
// https://leetcode.com/problems/rearrange-array-elements-by-sign/

class Solution {
  public int[] rearrangeArray(int[] nums) {
      int n = nums.length;
      int[] res = new int[n];
      int posIndex = 0, negIndex = 0;

      while (posIndex < n && nums[posIndex] < 0) {
          posIndex++;
      }
      while (negIndex < n && nums[negIndex] > 0) {
          negIndex++;
      }

      for (int i = 0; i < n; i += 2) {
          res[i] = nums[posIndex];
          res[i + 1] = nums[negIndex];

          // 移動到下一個正數的位置
          posIndex++;
          while (posIndex < n && nums[posIndex] < 0) {
              posIndex++;
          }

          // 移動到下一個負數的位置
          negIndex++;
          while (negIndex < n && nums[negIndex] > 0) {
              negIndex++;
          }
      }
      return res;
  }
}

/**
 * 重新排列數組元素，使得所有正數和負數之間交替出現，同時保持正數和負數在原數組中的相對位置
 * 
 * 我們可以先找出第一個正數和第一個負數的位置
 * 使用兩個獨立的指針填充結果數組
 * 填充後在移動到下一個正數和下一個負數的位置
 **/