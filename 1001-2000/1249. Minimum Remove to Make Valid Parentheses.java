// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/

import java.util.*;
class Solution {
  public String minRemoveToMakeValid(String s) {
      Stack<Integer> stack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      Set<Integer> set = new HashSet<>(); // need to remove

      // find all indexs need to remove
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c == '(') {
              stack.push(i);
          } else if (c == ')') {
              if (!stack.isEmpty()) {
                  stack.pop(); // has matched '(' for ')'
              } else {
                  // no match '(', mark ')' need to be remove
                  set.add(i);
              }
          }
      }
      // remaining '(' are invalid, put into set
      while (!stack.isEmpty()) {
          set.add(stack.pop());
      }
      // construct the valid str
      for (int i = 0; i < s.length(); i++) {
          if (!set.contains(i)) {
              sb.append(s.charAt(i));
          }
      }
      return sb.toString();
  }
}