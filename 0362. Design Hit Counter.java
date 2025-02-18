// Medium
// Design, Queue
// https://leetcode.cn/problems/design-hit-counter/

import java.util.*;

class HitCounter {
  // When a new hit occur, push its timestamp to queue
  // When retrieve the hit, remove timestamps that are older than 300 sec relative to the cur timestamp
  // The size of the queue at any time gives the number of hits in the last 300 seconds
  private Queue<Integer> que;

  public HitCounter() {
      que = new LinkedList<>();
  }
  
  public void hit(int timestamp) {
      que.offer(timestamp);
  }
  
  public int getHits(int timestamp) {
      while (!que.isEmpty() && que.peek() <= timestamp - 300) {
          que.poll();
      }
      return que.size();
  }
}
