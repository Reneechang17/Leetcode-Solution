// Medium
// Stack
// O(N)
// https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int evalRPN(String[] tokens) {
      // 逆波蘭表達式：用棧操作，遇到數字就入棧，遇到符號的話pop出棧頂的兩個做操作，然後將結果壓入棧
      Deque<Integer> stack = new ArrayDeque<>();

      for(String t : tokens) {
          if (t.length() > 1 || Character.isDigit(t.charAt(0))) {
              stack.push(Integer.parseInt(t));
          } else {
              int y = stack.pop();
              int x = stack.pop();
              switch (t) {
                  case "+":
                      stack.push(x + y);
                      break;
                  case "-":
                      stack.push(x - y);
                      break;
                  case "*":
                      stack.push(x * y);
                      break;
                  default:
                      stack.push(x / y);
                      break;
              }
          }
      }
      return stack.pop();
  }
}
