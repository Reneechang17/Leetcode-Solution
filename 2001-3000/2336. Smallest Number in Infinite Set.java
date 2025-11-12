// Medium
// Heap, Set
// Time:O(logn),Space:O(n)
// https://leetcode.cn/problems/smallest-number-in-infinite-set/

import java.util.*;

class SmallestInfiniteSet {
    private int nextSmallest;
    private PriorityQueue<Integer> heap;
    private Set<Integer> set;

    public SmallestInfiniteSet() {
        nextSmallest = 1;
        heap = new PriorityQueue<>();
        set = new HashSet<>();
    }

    public int popSmallest() {
        if (!heap.isEmpty()) {
            int smallest = heap.poll();
            set.remove(smallest);
            return smallest;
        }
        return nextSmallest++;
    }

    public void addBack(int num) {
        if (num < nextSmallest && !set.contains(num)) {
            heap.offer(num);
            set.add(num);
        }
    }
}
