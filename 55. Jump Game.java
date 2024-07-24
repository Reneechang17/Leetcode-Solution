// Medium
// Greedy
// O(n)
// https://leetcode.com/problems/jump-game/

class Solution {
  public boolean canJump(int[] nums) {
      if (nums.length == 1) return true;

      int coverage = 0;
      for (int i = 0; i <= coverage; i++) {
          coverage = Math.max(coverage, i + nums[i]); // 更新最大覆蓋範圍

          if (coverage >= nums.length - 1) {
              return true;
          }
      }
      return false;
  }
}

/**
 * 跳躍遊戲：給定一個非負整數數組，最初位於數組第一個位置。數組中每一個元素代表在該位置可以跳躍的最大長度，判斷是否能到最後一個位置
 * 
 * 思路：這題可以轉換成貪心的思維，我們每次都取最大的cover範圍，這樣在全局check一下這個範圍是否大於等於數組的長度，就代表我們可不可以跳過去
 * Note:記得要更新coverage
 **/