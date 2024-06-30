// Easy
// Stack
// O(n)
// https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else {
        if (stack.isEmpty() || stack.pop() != c) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

/**
 * 棧的經典題
 * 
 * 我們遍歷這個字符串（要toCharArray變成數組遍歷）
 * 如果當前是({[,就在棧中壓入對應的]})
 * 
 * 如果當前字符是閉括號，就先檢查棧是否為空
 * 如果為空，代表沒有對應的開括號
 * 如果不為空，就彈出棧頂的元素並check和c是否一樣
 * 
 * 最後檢查棧是否為空，如果為空才全部匹配完，如果不為空代表有沒有匹配成功的括號
 **/