// Medium
// Greedy
// O(n)
// https://leetcode.cn/problems/jump-game-ii/

class Solution {
  public int jump(int[] nums) {
      if (nums.length == 1 || nums.length == 0 || nums == null) return 0;

      int count = 0, curMaxRange = 0, maxRange = 0;

      for (int i = 0; i < nums.length; i++) {
          maxRange = Math.max(maxRange, i + nums[i]);

          if (maxRange >= nums.length - 1) {
              count++;
              break;
          }

          if (i == curMaxRange) {
              curMaxRange = maxRange;
              count++;
          }
      }
      return count;
  }
}

/**
 * 跳躍遊戲II：這次的限制是用最少的步數跳到數組的結尾
 * 而55題只要確定能跳到結尾就好
 * 
 * 因此這題我們還需要有兩個變量分別紀錄當前跳躍可以到達的最遠位置 以及 所有可選的跳躍中可以到達的最遠位置
 * 然後遍歷數組，對於每一個位置i，計算從這個位置最多能跳到哪裡？（i+nums[i])，並更新maxRange
 * 檢查當前索引是否到達了我們之前計算的當前最遠距離，如果到達的話就把curMaxRange更新為maxRange，並把count++
 * 
 * 檢查當前索引之前可以先檢查： 如果maxRange已經可以跳到結尾了，就count++並跳出循環
 **/