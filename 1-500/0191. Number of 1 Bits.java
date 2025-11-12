// Easy
// Bit Manipulation
// Time:O(k),Space:O(1)
// https://leetcode.cn/problems/number-of-1-bits/

class Solution {
  public int hammingWeight(int n) {
      int count = 0;
      while (n != 0) {
          n &= n - 1;
          count++;
      }
      return count;
  }
}
