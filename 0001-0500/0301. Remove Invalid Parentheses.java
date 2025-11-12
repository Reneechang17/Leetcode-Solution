// Hard
// Backtracking
// Time:O(2^n),Space:O(n)
// https://leetcode.cn/problems/remove-invalid-parentheses/

import java.util.*;
class Solution {
  private Set<String> res = new HashSet<>();

  public List<String> removeInvalidParentheses(String s) {
      int left = 0, right = 0;
      // calculate remove '(' and ')'
      for (char c : s.toCharArray()) {
          if (c == '(') {
              left++;
          } else if (c == ')') {
              if (left > 0) {
                  left--;
              } else {
                  right++;
              }
          }
      }
      // backtrack to delete invalid brackets
      backtracking(s, 0, left, right, 0, new StringBuilder());
      return new ArrayList<>(res);
  }
  private void backtracking(String s, int i, int left, int right, int open, StringBuilder sb) {
      if (i == s.length()) {
          if (left == 0 && right == 0 && open == 0) {
              res.add(sb.toString());
          }
          return;
      }
      char c = s.charAt(i);
      int n = sb.length();
      // delete '('
      if (c == '(' && left > 0) {
          backtracking(s, i + 1, left - 1, right, open, sb);
      }
      // delete ')'
      if (c == ')' && right > 0) {
          backtracking(s, i + 1, left, right - 1, open, sb);
      }
      // keep cur str
      sb.append(c);
      
      if (c != '(' && c != ')') {
          backtracking(s, i + 1, left, right, open, sb);
      } else if (c == '(') {
          backtracking(s, i + 1, left, right, open + 1, sb);
      } else if (open > 0) {
          backtracking(s, i + 1, left, right, open - 1, sb);
      }
      sb.setLength(n); // backtrack
  }
}
