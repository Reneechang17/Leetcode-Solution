// Easy
// Array
// O(mn)
// https://leetcode.cn/problems/richest-customer-wealth/

class Solution {
  public int maximumWealth(int[][] accounts) {
      int ans = 0;
      for (int[] acc : accounts) {
          int sum = 0;
          for (int w : acc) {
              sum += w;
          }
          ans = Math.max(ans, sum);
      }
      return ans;
  }
}

/**
 * 兩層增強for直接找最大的sum即可
 **/