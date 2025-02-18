// Medium
// Stack
// O(n)
// https://leetcode.cn/problems/simplify-path/

import java.util.Stack;

class Solution {
  public String simplifyPath(String path) {
      Stack<String> stack = new Stack<>();
      String[] parts = path.split("/");

      for (String part : parts) {
          // ignore the empty string and current directory
          if (part.equals("") || part.equals(".")) {
              continue;
          } else if (part.equals("..")) {
              // back to prev directory
              if (!stack.isEmpty()) {
                  stack.pop();
              }
          } else {
              // push the normal file to stack
              stack.push(part);
          }
      }
      return "/" + String.join("/", stack);
  }
}
