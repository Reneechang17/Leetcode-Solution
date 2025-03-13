// Hard
// Heap, Hash Table
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/sliding-window-median/

import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = dh.getMedian();
        for (int i = k; i < nums.length; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            res[i - k + 1] = dh.getMedian();
        }
        return res;
    }
}
class DualHeap {
    private PriorityQueue<Integer> small; // 大根堆：维护较小的一半元素
    private PriorityQueue<Integer> large; // 小根堆：维护较大的一半元素
    private Map<Integer, Integer> map; // 记录延迟删除的元素，key:元素，val:需删除的次数

    // small和large当前包含的元素个数，需要扣除被延迟删除的元素
    private int k, smallSize, largeSize; 

    public DualHeap(int k) {
        this.small = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2.compareTo(num1);
            }
        });
        this.large = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1.compareTo(num2);
            }
        });
        this.map = new HashMap<Integer, Integer>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian() {
        return (k & 1) == 1 ? small.peek() : ((double)small.peek() + large.peek()) / 2;
    }

    public void insert(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }
        makeBalance();
    }

    public void makeBalance() {
        // 调整small和large中的元素个数，使得两者的元素个数满足要求
        if (smallSize > largeSize + 1) {
            // small比large多2个
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small); // small堆顶元素被移除，需要prune
        } else if (smallSize < largeSize) {
            // large比small多1个
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }

    public void prune(PriorityQueue<Integer> heap) {
        // 不断从堆顶弹出元素、更新哈希表
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    public void erase(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            largeSize--;
            if (num == large.peek()) {
                prune(large);
            }
        }
        makeBalance();
    }
}
