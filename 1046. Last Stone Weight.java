// Easy
// PriorityQueue
// Time:O(n logn), Space:O(n)
// https://leetcode.cn/problems/last-stone-weight/

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            maxHeap.offer(s);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
