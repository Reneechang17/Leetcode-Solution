// Easy
// https://leetcode.cn/problems/xor-operation-in-an-array/

class Solution {
  public int xorOperation(int n, int start) {
      int x = start;
      for (int i = 1; i < n; i++) {
          x ^= start + 2 * i;
      }
      return x;
  }
}
