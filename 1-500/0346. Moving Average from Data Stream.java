// Easy
// Queue
// Time:O(1),Space:O(size)
// https://leetcode.cn/problems/moving-average-from-data-stream/

import java.util.*;

class MovingAverage {
    Queue<Integer> que;
    int size;
    double sum;

    public MovingAverage(int size) {
        que = new ArrayDeque<Integer>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        if (que.size() == size) {
            sum -= que.poll();
        }
        que.offer(val);
        sum += val;
        return sum / que.size();
    }
}
