// Medium
// Stack
// https://leetcode.cn/problems/decode-string/

import java.util.Stack;

class Solution {
    // Use stacks to handle nested structures:
    //  - Push cur string and num to stacks when '[' is encountered.
    //  - Build the repeated substring when ']' is encountered.
    //  - Append chars to the cur string otherwise.
  public String decodeString(String s) {
      Stack<String> strStack = new Stack<>();
      Stack<Integer> numStack = new Stack<>();
      StringBuilder curStr = new StringBuilder();
      int curNum = 0;

      for (char c : s.toCharArray()) {
          if (Character.isDigit(c)) {
              // construct multi-digit number
              curNum = curNum * 10 + (c - '0');
          } else if (c == '[') {
              // push cur string and num to stacks, reset for new context
              numStack.push(curNum);
              strStack.push(curStr.toString());
              curStr = new StringBuilder();
              curNum = 0;
          } else if (c == ']') {
              // decode the string using the top num and append to the top str
              int times = numStack.pop();
              StringBuilder decodedStr = new StringBuilder(strStack.pop());
              for (int i = 0; i < times; i++) {
                  decodedStr.append(curStr);
              }
              // update cur string
              curStr = decodedStr;
          } else {
              // add regular chars to the cur string
              curStr.append(c);
          }
      }
      return curStr.toString();
  }
}
