// Easy
// Array
// O(n)
// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

class Solution {
  public int maximumCount(int[] nums) {
    int pos = 0, neg = 0;
    // iterate the number in nums and count
    // positive and negative directly
    for (int x : nums) {
      if (x > 0) {
        ++pos;
      } else if (x < 0) {
        ++neg;
      }
    }
    // return the bigger one
    return Math.max(pos, neg);
  }
}

// 直接計算pos和neg的個數，用Math的max直接比較大小