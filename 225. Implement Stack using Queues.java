// Easy
// Queue, Design
// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
  Queue<Integer> q1;
  Queue<Integer> q2;

  public MyStack() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  public void push(int x) {
    q2.offer(x);
    while (!q1.isEmpty()) {
      q2.offer(q1.poll());
    }
    Queue<Integer> queTemp;
    queTemp = q1;
    q1 = q2;
    q2 = queTemp;
  }

  public int pop() {
    return q1.poll();
  }

  public int top() {
    return q1.peek();
  }

  public boolean empty() {
    return q1.isEmpty();
  }
}

/**
 * 這題用隊列模擬一個棧
 * 
 * 需要先明確：
 * 棧-> 先進後出
 * 隊列-> 先進先出
 * 
 * 思路：用兩個隊列來模擬
 * 首先把元素裝入q2中
 * 如果q1隊列不為空，我們把q2元素逐個裝到q1中，以確保最新插入的元素一直都在隊列的最前端
 * 然後我們交換一下q1和q2的引用，從q1彈出和棧一個順序的元素
 **/