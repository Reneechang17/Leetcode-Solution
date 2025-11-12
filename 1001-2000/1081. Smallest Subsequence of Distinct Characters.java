// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters/

import java.util.*;

class Solution {
  public String smallestSubsequence(String s) {
      char[] chars = s.toCharArray();
      int[] num = new int[26];
      for (int i = 0; i < chars.length; i++) {
          num[chars[i] - 'a'] = i;
      }

      Deque<Character> stack = new ArrayDeque<>();
      boolean[] vis = new boolean[26];
      for (int i = 0; i < chars.length; i++) {
          if (vis[chars[i] - 'a']) continue;
          while (!stack.isEmpty() && stack.peekLast() > chars[i] && num[stack.peekLast() - 'a'] > i) {
              Character c = stack.removeLast();
              vis[c - 'a'] = false;
          }
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
