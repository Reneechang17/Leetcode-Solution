// Hard
// PriorityQueue
// Time:O(logn)->add,O(1)->find,Space:O(n)
// https://leetcode.cn/problems/find-median-from-data-stream/

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // left
    private PriorityQueue<Integer> minHeap; // right

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        // max value in maxHeap <= min value in minHeap
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        // make sure two heap's size < 1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
