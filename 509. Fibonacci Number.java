// Easy
// Math
// O(n)
// https://leetcode.com/problems/fibonacci-number/

class Solution {
  public int fib(int n) {
      if (n < 2) return n;
      int a = 0, b = 1, c = 0;

      for (int i = 1; i < n; i++) {
          c = a + b;
          a = b;
          b = c;
      }
      return c;
  }
}

/**
 * 斐波那契數，這題是學習DP中狀態轉移的經典題
 * 但是其實也沒必要用DP，會顯得太複雜，直接用簡單的數學概念並循環重新賦值即可
 **/