// Medium
// Math
// Time:O(log10(x)), Space:O(1)
// https://leetcode.cn/problems/reverse-integer/

class Solution {
  // We can extract digit one by one(x % 10) and add them to res to reverse integer
  // And check if res exceed the 32-bit range
  public int reverse(int x) {
      long res = 0;
      while (x != 0) {
          res = res * 10 + x % 10;
          x /= 10;
          if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
              return 0;
          }
      }
      return (int) res;
  }
}
