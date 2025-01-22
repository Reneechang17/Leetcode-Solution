// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/valid-parenthesis-string/

import java.util.Stack;

class Solution {
  // Use two stacks: one for '(' indexs and another for '*' indexs
  //    - Push '(' index to leftStack
  //    - Push '*' index to starStack
  //    - For ')', prioritize matching '(' from leftStack. If not, match '*' from starStack
  // Finally, try to match remaining '(' with '*'. Ensure '*' appears after '('
  // If any '(' remains unmatched, return false. Otherwise, return true
  public boolean checkValidString(String s) {
      Stack<Integer> leftStack = new Stack<>();
      Stack<Integer> starStack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c == '(') {
              leftStack.push(i);
          } else if (c == '*') {
              starStack.push(i);
          } else {
              if (!leftStack.isEmpty()) {
                  leftStack.pop();
              } else if (!starStack.isEmpty()) {
                  starStack.pop();
              } else {
                  return false;
              }
          }
      }

      // match remaining '(' with '*' 
      while (!leftStack.isEmpty() && !starStack.isEmpty()) {
          if (leftStack.pop() > starStack.pop()) {
              return false;
          }
      }
      return leftStack.isEmpty();
  }
}
