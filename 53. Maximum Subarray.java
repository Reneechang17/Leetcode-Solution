// Medium
// Greedy
// O(n)
// https://leetcode.com/problems/maximum-subarray/

class Solution {
  public int maxSubArray(int[] nums) {
      if (nums.length == 1) {
          return nums[0];
      }

      int sum = Integer.MIN_VALUE;
      int count = 0;

      for (int i = 0; i < nums.length; i++) {
          count += nums[i];
          sum = Math.max(count, sum);
          if (count <= 0) {
              count = 0;
          }
      }
      return sum;
  }
}

/**
 * 最大子序和：即找出一個整數數組中具有最大和的連續子數組（至少包含一個數字）
 * 
 * 這題可以用Kadane's algorithm的核心思想：通過一次遍歷同時計算當前最大子數組和並決定是否該捨棄之前的累計和
 * 在遍歷nums數組時，從頭開始用count累積，並用一個變量sum來不斷更新最大子序和，一旦count加上nums[i]為負數，那就從nums[i+1]開始重新count（count從0開始）
 * 不用擔心會錯過最大值，因為sum一直在紀錄最大值
 * 
 * 為什麼要重置count？
 * 任何包含負總和的子數組都不會是最大總和子數組的一部分
 * 當發現累積和變為0或是負數時，就從下一個元素開始重新計算，尋找新的可能的最大子數組和
 **/