// Hard
// Array, Hash Table(原地哈希)
// O(n)
// https://leetcode.com/problems/first-missing-positive/

class Solution {
  public int firstMissingPositive(int[] nums) {
      // 解法：原地哈希
      int n = nums.length;

      // 處理所有存在的負數，把他們都變成n+1，因為這對於找最小缺失的正整數無關
      for (int i = 0; i < n; i++) {
          if (nums[i] <= 0) {
              nums[i] = n + 1;
          }
      }

      // 遍歷修改後的數組，如果這個數字在1<=x<=n,就把它應該出現的位置的數字變為負數，表示這個數字是存在的
      for (int i = 0; i < n; i++) {
          int num = Math.abs(nums[i]);
          if (num <= n) {
              nums[num - 1] = -Math.abs(nums[num - 1]);
          }
      }

      // 再遍歷數組，找到第一個數字為正的位置，其索引+1就是我們要找的最小缺失正整數
      for (int i = 0; i < n; i++) {
          if (nums[i] > 0) {
              return i + 1;
          }
      }

      // 如果最後所有位置都是負數，代表都被標記過，那麼答案就是n+1
      return n + 1;
  }
}

/**
 * 給定一個未排序的數組，找到一個未出現的最小正整數
 * 需要在時間複雜度O(n) & 不使用額外空間來做
 **/