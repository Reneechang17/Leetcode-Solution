// Medium
// Math
// Time:O(min(x, y)), Space:O(1)
// https://leetcode.cn/problems/water-and-jug-problem/

class Solution {
  // This problem can be solved only if it is a multiple of
  // gcd(x, y). greatest common divisor是最大公倍数
  public boolean canMeasureWater(int x, int y, int target) {
      if (target > x + y) return false;
      return target % gcd(x, y) == 0;
  }
  private int gcd(int a, int b) {
      while (b != 0) {
          int tmp = a % b;
          a = b;
          b = tmp;
      }
      return a;
  }
}