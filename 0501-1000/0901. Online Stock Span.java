// Medium
// OOD, Monotonic Stack
// O(n)
// https://leetcode.com/problems/online-stock-span/

import java.util.Stack;

class StockSpanner {
  Stack<int[]> stack;

  public StockSpanner() {
      stack = new Stack<>();
  }
  
  public int next(int price) {
      int span = 1;
      
      while (!stack.isEmpty() && stack.peek()[0] <= price) {
          span += stack.pop()[1];
      }
      stack.push(new int[]{price, span});
      return span;
  }
}

/**
 * 設計一個接收每日股價的類，並能返回從今天往回看，估計一直小於或是等於今天的連續天數
 * 
 * 這題是一個經典的單調棧設計題，我們可以用一個單調遞減棧來記錄每天的股價和對應的連續天數
 * 對於每個新的股價，如果棧頂的股價小於等於當前股價，則將棧頂元素出棧，並將對應的連續天數加到當前天數上
 **/