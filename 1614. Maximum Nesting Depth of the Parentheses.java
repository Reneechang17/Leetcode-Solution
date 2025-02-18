// Easy
// Iteration
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/

class Solution {
  public int maxDepth(String s) {
      int count = 0, max = 0;
      for (char c : s.toCharArray()) {
          if (c == '(') {
              count++;
              max = count > max ? count : max;
          } else if (c == ')') {
              count--;
          }
      }
      return max;
  }
}
