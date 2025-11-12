// Easy
// Queue
// https://leetcode.cn/problems/number-of-recent-calls/

import java.util.*;

class RecentCounter {
    private Queue<Integer> que;
    
    public RecentCounter() {
        que = new LinkedList<>();
    }

    public int ping(int t) {
        que.offer(t);

        // remove the requests not in [t-3000, t]
        while (!que.isEmpty() && que.peek() < t - 3000) {
            que.poll();
        }
        return que.size();
    }
}
