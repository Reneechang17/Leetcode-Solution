// Easy
// Array, Binary Search, Sorting
// O(n * logn)
// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

import java.util.Arrays;
class Solution {
  public int specialArray(int[] nums) {
      Arrays.sort(nums);
      int len = nums.length;
      for(int x = 1; x <= len; ++x){
          int left = 0, right = len;
          while(left < right){
              int mid = (left + right) >> 1;
              if(nums[mid] >= x){
                  right = mid;
              } else {
                  left = mid + 1;
              }
          }
          int cnt = len - left;
          if(cnt == x){
              return x;
          }
      }
      return -1;
  }
}

/**
 * 這題的x只是一個特徵值，它不一定存在於數組中
 * 這個特徵值需要滿足：數組中恰好有x個元素大於or等於x
 * 
 * 代碼思路：
 * 1. 先將數組進行排序
 * 2. 外層for遍歷數組，從1～nums.length()，嘗試每一個可能的x
 * 3. 內層while循環用二分查找找數組中大於或等於x的最小元素的位置
 * 4. 循環結束之後，left應該會指向第一個大於等於x的位置（用nums.length-left計算具體的數量）
 * 5. 如果這個count和x正好相等，那麼x就是這個數組的特徵值，如果找不到就返回-1
 **/