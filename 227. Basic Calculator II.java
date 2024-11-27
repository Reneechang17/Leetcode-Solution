// Medium
// Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/basic-calculator-ii/

import java.util.Stack;

class Solution {
  public int calculate(String s) {
      int n = s.length();
      Stack<Integer> stack = new Stack<>();
      char sign = '+';
      int num = 0;

      for (int i = 0; i < n; i++) {
          char c = s.charAt(i);
          if (Character.isDigit(c)) {
              num = num * 10 + c - '0';
          }
          if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
              switch(sign) {
                  case '+':
                      stack.push(num);
                      break;
                  case '-':
                      stack.push(-num);
                      break;
                  case '*':
                      int x = stack.pop();
                      stack.push(num * x);
                      break;
                  default:
                      stack.push(stack.pop() / num);
                      break;
              }
              sign = c;
              num = 0;
          }
      }
      int res = 0;
      while (!stack.isEmpty()) {
          res += stack.pop();
      }
      return res;
  }
}
