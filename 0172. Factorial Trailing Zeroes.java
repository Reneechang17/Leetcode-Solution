// Medium
// Math
// Time:O(log_5(n)),Space:O(1)
// https://leetcode.cn/problems/factorial-trailing-zeroes/

class Solution {
  // 末尾的0有因数10产生，10又由2*5得
  // 在计算n!时，因子2的数量远超过因子5，所以阶乘末尾0的数量实际上由因子5的数量决定
  public int trailingZeroes(int n) {
      int cnt = 0;
      while (n >= 5) {
          cnt += n / 5;
          n /= 5;
      }
      return cnt;
  }
}
