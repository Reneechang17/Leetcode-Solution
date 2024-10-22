// Easy
// Greedy, Simulation
// O(n)
// https://leetcode.cn/problems/minimum-time-to-type-word-using-special-typewriter/

class Solution {
  // Simulation
  public int minTimeToType(String word) {
      int ans = 0;
      int pre = 0;

      for (char c : word.toCharArray()) {
          int cur = c - 'a';
          int dis = Math.abs(pre - cur); // it will not be negative
          dis = Math.min(dis, 26 - dis); // Greedy: choose the minimum distance
          ans += dis + 1; // dis是point到目標位置，但是還需要jump到下一個才算完成這個字符的輸入，+1就是這個操作
          pre = cur;
      }
      return ans;
  }
}
