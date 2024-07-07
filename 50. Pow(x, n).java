// Medium
// Math
// O(log N)
// https://leetcode.com/problems/powx-n/

class Solution {
  public double myPow(double x, int n) {
      long N = n;
      if (N < 0) {
          x = 1 / x;
          N = -N;
      }

      double ans = 1;
      double cur = x;
      for (long i = N; i > 0; i /= 2) {
          if ((i % 2) == 1) {
              ans *= cur;
          }
          cur *= cur;
      }
      return ans;
  }
}

/**
 * 這題是計算x的n次方，使用快速冪方法，通過將n轉換為二進制來減少計算次數
 * 
 * 如果n為負，將x取倒數 1/x，並將n取絕對值
 * 初始化ans = 1，用cur來存儲當前x的乘積
 * 逐步將n除以2，每次迭代都將cur自乘（cur * cur），如果n當前的值為奇數，則將cur累乘到ans中
 * 繼續迭代到n = 0
 **/