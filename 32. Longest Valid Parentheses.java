// Hard
// Stack
// O(n)
// https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

class Solution {
  public int longestValidParentheses(String s) {
      int maxLen = 0;
      Stack<Integer> stack = new Stack<>();
      stack.push(-1);

      for(int i = 0; i < s.length(); i++) { 
          if(s.charAt(i) == '(') {
              stack.push(i);
          } else {
              stack.pop();
              if(stack.isEmpty()) {
                  stack.push(i);
              } else {
                  maxLen = Math.max(maxLen, i - stack.peek());
              }
          }
      }
      return maxLen;
  }
}

/**
 * 這題可以用棧來操作
 * 
 * 因為返回的是int 長度，所以我們需要紀錄的是索引的位置
 * 可以用棧來紀錄左括號的索引
 * 如果當前遍歷到的是右括號，彈出棧頂元素與之相配
 *    如果彈出後棧為空，就把當前右括號的索引入棧
 *    如果棧不為空，就計算當前元素與棧頂元素的距離
 **/