// Easy
// Prefix Sum, Two Pointers
// O(n)
// https://leetcode.cn/problems/find-pivot-index/

class Solution {
  public int pivotIndex(int[] nums) {
      int left = 0, right = 0;
      int n = nums.length;

      for (int num : nums) {
          right += num;
      }

      for (int i = 0; i < n; i++) {
          right -= nums[i];
          if (left == right) {
              return i;
          }
          left += nums[i];
      }
      return -1;
  }
}

/**
 * 找數組的中心索引：給定一個整數數組nums，中心索引是指數組的左邊所有元素的和等於右邊所有元素的和的索引
 * 
 * 思路：通過計算左側前綴和與總和的差值，來判斷是否為中心索引
 * 首先先計算數組總和，將其賦值給右側，然後遍歷數組，每次將右側減去當前值，判斷左側與右側是否相等
 * 如果不相等，則將當前值加到左側，繼續遍歷
 * **/