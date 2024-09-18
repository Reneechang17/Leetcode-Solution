// Easy
// Binary Search
// O(logn)
// https://leetcode.com/problems/valid-perfect-square/

class Solution {
  public boolean isPerfectSquare(int num) {
      int left = 1, right = num;
      while (left < right) {
          int mid = (left + right) >> 1;
          if (1L * mid * mid >= num) {
              right = mid; 
          } else {
              left = mid + 1;
          }
      }
      return left * left == num;
  }
}

/**
 * 有效的完全平方數：經典的二分查找問題，核心思路是對於一個數num，我們可以對其進行二分查找，找到其平方根，然後判斷平方根的平方是否等於num
 * 注意：在計算mid * mid時，我們需要將mid轉換為長整型，也就是乘上1L，否則可能會整型溢出
 * 因為mid * mid計算的是兩個整數的乘積，如果mid足夠大，例如當num接近2^31時，mid * mid可能會超出int類型的範圍
 **/