// Medium
// Stack, String
// O(n)
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

import java.util.Stack;

class Solution {
  class Pair {
      char character;
      int count;
      Pair(char character, int count) {
          this.character = character;
          this.count = count;
      }
  }
  public String removeDuplicates(String s, int k) {
      Stack<Pair> stack = new Stack<>();
      for (char c : s.toCharArray()) {
          if(!stack.isEmpty() && stack.peek().character == c) {
              stack.peek().count++;
              if(stack.peek().count == k) {
                  stack.pop();
              }
          } else {
              stack.push(new Pair(c, 1));
          }
      }

      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty()) {
          Pair p = stack.pop();
          while(p.count-- > 0) {
              sb.append(p.character);
          }
      }

      return sb.reverse().toString();
  }
}

/**
 * 用棧來紀錄當前遍歷的字符以及他出現的次數（另外開了一個內部類Pair）
 * 遍歷字符串，如果棧頂的元素和當前遍歷的元素是一個，則count++，當count達到k的時候就出棧
 * 如果當前字符沒有出現在棧中，則new一個新的Pair入棧
 * 
 * 然後用StringBuilder把棧中的元素進行拼接
 * Note：拼接的條件是count非零的時候持續拼接
 * 因為棧的特性，最後要把字符串反轉一下再toString
 **/