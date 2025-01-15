// Easy
// https://leetcode.cn/problems/number-of-good-pairs/

class Solution {
  public int numIdenticalPairs(int[] nums) {
      int[] count = new int[101];
      int ans = 0;
      for (int x : nums) {
          ans += count[x];
          count[x]++;
      }
      return ans;
  }
}
