// Medium
// Semaphore, Design, Queue
// https://leetcode.com/problems/design-bounded-blocking-queue/

import java.util.*;
import java.util.concurrent.Semaphore;

class BoundedBlockingQueue {
  private Semaphore s1;
  private Semaphore s2;
  private Deque<Integer> que = new ArrayDeque<>();

  public BoundedBlockingQueue(int capacity) {
      s1 = new Semaphore(capacity);
      s2 = new Semaphore(0);
  }
  
  public void enqueue(int element) throws InterruptedException {
      s1.acquire();
      que.offer(element);
      s2.release();
  }
  
  public int dequeue() throws InterruptedException {
      s2.acquire();
      int ans = que.poll();
      s1.release();
      return ans;
  }
  
  public int size() {
      return que.size();
  }
}

/**
 * 設計有限阻塞隊列：實現一個有如下方法的線程安全有限阻塞隊列
 * BoundedBlockingQueue(int capacity)：構造方法初始化隊列，其中capacity表示隊列長度的上限
 * enqueue(int element)：將一個元素放入隊列中，如果隊列已滿，則等待直到隊列不滿
 * dequeue()：從隊列中取出一個元素，如果隊列為空，則等待直到隊列不為空
 * size()：返回當前隊列的元素個數
 * 實現會被多線程同時訪問測試，每個線程要嘛用一個只調用enqueue方法的生產者線程，要嘛是只調用dequeue方法的消費者線程，size方法在每一個測試後都會被調用
 * 不能使用內置的有限阻塞隊列
 **/