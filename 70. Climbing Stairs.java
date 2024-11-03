// Easy
// DP
// O(n)
// Similar: 509
// https://leetcode.cn/problems/climbing-stairs/

class Solution {
  // dp
  // when n is smaller then 2, like 1, so only 1 way, if 2, there are 2 ways
  // for base, a = 1, and b means if there are n steps, we have b ways
  // and we iterate from 3, since the case 0,1,2 we have already covered.
  public int climbStairs(int n) {
      if (n <= 2) {
          return n;
      }

      int a = 1, b = 2, sum = 0;
      for (int i = 3; i <= n; i++) {
          sum = a + b;
          a = b;
          b = sum;
      }
      return b; // b表示爬到第n階的方法數
  }
}

/**
 * 爬樓梯：需要n階才可以到樓頂，每次可以選擇爬1or2，有多少種爬法？
 * DP思路：爬到第一層樓有一種方法，爬到第二層樓則有兩種方法，爬到第三層樓的狀態可以由第一層樓梯和第二層樓梯的狀態做推導
 **/
