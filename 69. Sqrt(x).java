// Easy
// Binary Search
// O(logn)
// https://leetcode.cn/problems/sqrtx/

class Solution {
  // 實現一個函數計算給定的非負整數x的平方根，並返回整數部分，去掉小數部分
  // 這題可以用二分查找，因為平方根不會超過x的一半，可以用二分來找到這個平方根的整數部分
  public int mySqrt(int x) {
      if (x < 2) {
          return x;
      }

      int left = 1, right = x / 2;
      while (left <= right) {
          // 用mid的平方，來判斷應該往哪裡找x
          int mid = left + (right - left) / 2;
          long s = (long) mid * mid;

          if (s == x) {
              return mid;
          } else if (s < x) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return right; // right會是小於平方根的最大整數
  }
}
