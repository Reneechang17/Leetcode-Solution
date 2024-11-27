// Easy
// Bit Manipulation
// Time:O(1),Space:O(1)
// https://leetcode.cn/problems/reverse-bits/

class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
      int res = 0;
      for (int i = 0; i < 32; i++) {
          int bit = n & 1; // Extract the last bit of n
          res = res << 1;  // Shift the res to the left to make room for the new bit
          res = res | bit; // Insert the bit into the res
          n = n >>> 1; // Shift n to the right to process the next bit
      }
      return res;
  }
}
