// Medium
// Two Pointers
// O(n)
// https://leetcode.cn/problems/sort-colors/

class Solution {
  public void sortColors(int[] nums) {
      // i 維護紅色的左邊界，j 維護藍色的右邊界，k指針遍歷數組
      int i = 0, j = nums.length - 1, k = 0;
      while (k <= j) {
          switch (nums[k]) {
              case 0:
                swap(nums, i, k);
                i++;
                k++;
                  break;
              case 1:
                  k++;
                  break;
                case 2:
                  swap(nums, k, j);
                  // 交換後的nums[k]不知道是什麼顏色，所以k不動
                // 需要再判斷一次nums[k]
                j--;
                  break;
          }
      }
  }

  private void swap (int[] nums, int i, int j) {
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