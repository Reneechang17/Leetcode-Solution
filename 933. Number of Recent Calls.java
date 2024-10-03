// Easy
// Queue
// O(n)
// https://leetcode.cn/problems/number-of-recent-calls/

import java.util.*;

class RecentCounter {
  private Queue<Integer> que;

  public RecentCounter() {
      que = new LinkedList<>();
  }
  
  public int ping(int t) {
      que.offer(t);

      // 移除所有不在[t-3000, t]範圍內的請求
      while (!que.isEmpty() && que.peek() < t - 3000) {
          que.poll();
      }
      return que.size();
  }
}
