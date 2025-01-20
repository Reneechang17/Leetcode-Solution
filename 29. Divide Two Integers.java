// Medium
// Bit Manipulation
// Time:O(log(dividend)), Space:O(1)
// https://leetcode.cn/problems/divide-two-integers/

class Solution {
  // 真的不会，直接抄了:>什么烂题
  public int divide(int dividend, int divisor) {
      // this case will cause overflow
      if (dividend == Integer.MIN_VALUE && divisor == -1) {
          return Integer.MAX_VALUE;
      }

      // convert both numbers to negative to avoid overflow
      boolean isNeg = (dividend > 0) ^ (divisor > 0);
      long lDividend = Math.abs((long) dividend);
      long lDivisor = Math.abs((long) divisor);
      int res = 0;

      // Doubling method to subtract larger multiples of divisor
      while (lDividend >= lDivisor) {
          long tmp = lDivisor, multiple = 1;
          while (lDividend >= (tmp << 1)) {
              tmp <<= 1;
              multiple <<= 1;
          }
          lDividend -= tmp;
          res += multiple;
      }
      return isNeg ? -res : res;
  }
}
