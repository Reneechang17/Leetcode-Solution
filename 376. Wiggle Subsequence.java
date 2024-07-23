// Medium
// Greedy
// O(n)
// https://leetcode.com/problems/wiggle-subsequence/

class Solution {
  public int wiggleMaxLength(int[] nums) {
      if (nums.length <= 1) {
          return nums.length;
      }
      int curDiff = 0;
      int preDiff = 0;
      int count = 1;

      for (int i = 1; i < nums.length; i++) {
          curDiff = nums[i] - nums[i - 1];

          if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
              count++;
              preDiff = curDiff;
          }
      }
      return count;
  }
}

/**
 * 擺動子序列：連續數字之間的差嚴格在正數負數之間交替
 * 而子序列指的是從原始數據中刪除部分（或是不刪除）獲取子序列，剩下的元素保持原本的順序
 * 
 * 思路：
 * 首先先想要刪除哪些數據？ 其實也可以不用刪除，因為題目要求找最長的
 * 局部最優：刪除單調上升的數據
 * 全局最優：整個序列有最多的局部峰值
 * 
 * 擺動判斷：當前差值為正且前一個差值非正 or 當前差值為負且前一個差值為正
 **/