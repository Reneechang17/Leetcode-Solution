// Medium
// Two Pointers, Math
// O(c^1/2)
// https://leetcode.com/problems/sum-of-square-numbers/

class Solution {
  public boolean judgeSquareSum(int c) {
      long a = 0, b = (long)Math.sqrt(c);
      while (a <= b) {
          long s = a * a + b * b;
          if (s == c) {
              return true;
          } 
          if (s < c) {
              a++;
          } else {
              b--;
          }
      }
      return false;
  }
}

/**
 * 平方數之和：給定一個非負整數c，判斷是否存在兩個整數a和b，使得a^2 + b^2 = c
 * 思路：使用雙指針，定義兩個指針a和b，分別指向0和c的平方根，然後在每一步中計算s = a^2 + b^2，如果s等於c，則返回true
 * 如果s小於c，則a++，否則b--，直到a大於b為止
 **/