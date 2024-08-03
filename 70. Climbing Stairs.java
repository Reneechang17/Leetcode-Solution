// Easy
// DP, Math
// O(n)
// Similar: 509
// https://leetcode.com/problems/climbing-stairs/

class Solution {
  public int climbStairs(int n) {
      if (n <= 2) return n;
      int a = 1, b = 2, sum = 0;

      for (int i = 3; i <= n; i++) {
          sum = a + b;
          a = b;
          b = sum;
      }
      return b;
  }
}

/**
 * 爬樓梯：需要n階才可以到樓頂，每次可以選擇爬1or2，有多少種爬法？
 * 
 * DP思路：爬到第一層樓有一種方法，爬到低二層樓則有兩種方法，爬到第三層樓的狀態可以有第一層樓梯和第二層樓梯的狀態做推導
 **/