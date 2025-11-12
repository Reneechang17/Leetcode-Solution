// Easy
// XOR Operation
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/single-number/

class Solution {
  public int singleNumber(int[] nums) {
      int ans = 0;
      for (int v : nums) ans ^= v;
      return ans;
  }
}

// x和0异或得x
// x和x异或得0
