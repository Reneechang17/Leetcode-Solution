// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/move-zeroes/

class Solution {
  public void moveZeroes(int[] nums) {
      int i = 0; 
      
      // 先用j指針填非0的元素
      for (int j = 0; j < nums.length; j++) {
          if (nums[j] != 0) {
              nums[i] = nums[j]; 
              // 再把0填到後面
              if (i != j) {
                  nums[j] = 0;
              }
              i++;
          }
      }
  }
}

/**
 * 移動零：給定一個整數數組nums，將所有0移動到數組的末尾，同時保持非零元素的相對順序
 * 不能使用額外空間，必須在原地修改輸入數組並在最短的時間內解決
 * 
 * 思路：j指針遍歷數組，先填入非0的，最後再把0填入
 **/