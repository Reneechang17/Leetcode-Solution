// Easy
// Bit Manipulation
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/number-of-even-and-odd-bits/

class Solution {
  public int[] evenOddBit(int n) {
      int even = 0, odd = 0, i = 0;
      while (n > 0) {
          if ((n & 1) == 1) {
              if (i % 2 == 0) {
                  even++;
              } else {
                  odd++;
              }
          }
          n >>= 1;
          i++;
      }
      return new int[] {even, odd};
  }
}
