// Medium
// Monotonic Stack
// O(n)
// https://leetcode.com/problems/daily-temperatures/

import java.util.Stack;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
      // 找右側第一個高溫
      // 用單調遞減棧
      int n = temperatures.length;
      int[] res = new int[n];
      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < n; i++) {
          while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
              int index = stack.pop();
              res[index] = i - index;
          }
          stack.push(i);
      }
      return res;
  }
}

/**
 * 每日溫度：找右側第一個高溫
 * 
 * 思路：用單調遞減棧
 * 用棧存儲數組的索引，這些索引對應的溫度值應該是遞減的，如果遇到一個溫度比棧頂索引對應溫度高的，則出棧，代表找到了右側第一個高溫
 * 出棧的同時需要紀錄那個溫度值的索引，並且計算出棧頂索引對應的溫度值與這個索引對應的溫度值的差值，這個差值就是答案
 **/