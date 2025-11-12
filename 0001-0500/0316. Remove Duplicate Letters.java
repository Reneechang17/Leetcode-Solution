// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/remove-duplicate-letters/

import java.util.*;

class Solution {
  // Get the last index of each char
  // Use stack to store -> LIFO to make sure the relative order
  // Check if the char has already in stack
  public String removeDuplicateLetters(String s) {
      char[] chars = s.toCharArray();
      // store the last index of each char
      int[] num = new int[26];
      for (int i = 0; i < chars.length; i++) {
          num[chars[i] - 'a'] = i;
      }

      Deque<Character> stack = new ArrayDeque<>();
      boolean[] vis = new boolean[26];

      for (int i = 0; i < chars.length; i++) {
          // if the cur char in stack -> continue
          if (vis[chars[i] - 'a']) continue;
          // use while loop:
          //  - stack must be non empty, and remove the top char and compare it with the cur char:
          //  - the top char of the stack is bigger than the cur char
          //  - the top char of the stack and then behind the cur char, still exists, 
          while (!stack.isEmpty() && stack.peekLast() > chars[i] && num[stack.peekLast() - 'a'] > i) {
              // remove the top char
              Character c = stack.removeLast();
              vis[c - 'a'] = false; // mark as not appear in stack
          }
          // or add the char in stack, and mark as appear in stack
          stack.addLast(chars[i]);
          vis[chars[i] - 'a'] = true;
      }

      StringBuilder sb = new StringBuilder();
      for (Character c : stack) {
          sb.append(c);
      }
      return sb.toString();
  }
}
