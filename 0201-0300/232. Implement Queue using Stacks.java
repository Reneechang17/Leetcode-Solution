// Easy
// Stack, Design
// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

class MyQueue {
  // 用兩個棧來模擬queue
  Stack<Integer> stackIn;
  Stack<Integer> stackOut;

  public MyQueue() {
      stackIn = new Stack<>();
      stackOut = new Stack<>();
  }
  
  // 正常將元素入棧
  public void push(int x) {
      stackIn.push(x);
  }
  
  // 當stackOut為空，就將stackIn元素轉入，然後由stackOut頂部彈出
  public int pop() {
      transferToOut();
      return stackOut.pop();
  }
  
  public int peek() {
      transferToOut();
      return stackOut.peek();
  }
  
  public boolean empty() {
      return stackIn.isEmpty() && stackOut.isEmpty();
  }

  // 把stackIn元素挪到stackOut
  private void transferToOut() {
      if(!stackOut.isEmpty()) return;
      while(!stackIn.isEmpty()) {
          stackOut.push(stackIn.pop());
      }
  }
}

/**
 * 這題用棧來實現隊列
 * 
 * 需要先明確：
 * 棧-> 先進後出
 * 隊列-> 先進先出
 * 
 * 思路：需要用兩個棧來模擬
 * 分別為輸入棧：負責裝元素進來
 *      輸出棧：負責彈出元素
 * 當輸出棧為空的時候，就把輸入棧的元素移到輸出棧，再從輸出棧的棧頂彈出元素，直到棧為空
 * 
 * 難點：怎麼把輸入棧的元素挪到輸出棧？
 * 解決：使用transferToOut方法操作
 * 當輸出棧為空的時候這個方法會被調用，把輸入棧的元素都push到輸出棧中
 **/