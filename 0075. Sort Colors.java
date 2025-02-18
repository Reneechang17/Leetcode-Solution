// Medium
// Two Pointers
// O(n)
// https://leetcode.cn/problems/sort-colors/

class Solution {
  public void sortColors(int[] nums) {
      int i = 0, j = nums.length - 1, k = 0;

      while (k <= j) {
          if (nums[k] == 0) {
              swap(nums, i, k);
              i++;
              k++;
          } else if (nums[k] == 1) {
              k++;
          } else {
              swap(nums, k, j);
              j--;
              // we no need to move k
              // since we don't know what's color of the nums[k]
          }
      }
  }

  private void swap(int[] nums, int i, int j) {
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
  }
}

/**
 * 思路：三指針法
 * 定義三個指針，i指針維護紅色的最右邊界，k遍歷數組，j指針維護藍色的最左邊界
 * 遍歷數組，知道k指針超過j指針
 * 
 * 如果nums[k]為紅色，就將nums[i]和nums[k]交換
 * 如果nums[k]為白色，k指針繼續走
 * 如果nums[k]為藍色，就將nums[j]和nums[k]交換
 **/