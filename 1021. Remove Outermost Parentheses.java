// Medium
// Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/remove-outermost-parentheses/

class Solution {
  public String removeOuterParentheses(String s) {
      StringBuilder sb = new StringBuilder();
      int depth = 0;
      for (char c : s.toCharArray()) {
          if (c == '(') {
              if (depth > 0) sb.append(c); // 非外层括号，保留
              depth++;
          } else {
              depth--;
              if (depth > 0) sb.append(c); // 非外层括号，保留
          }
      }
      return sb.toString();
  }
}
