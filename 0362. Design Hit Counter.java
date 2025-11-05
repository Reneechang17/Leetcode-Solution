// Medium
// Design, Queue
// https://leetcode.cn/problems/design-hit-counter/

import java.util.*;

class HitCounter {
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
