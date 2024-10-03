// Easy
// PriorityQueue, Heap
// O(log k)
// https://leetcode.cn/problems/kth-largest-element-in-a-stream/

import java.util.PriorityQueue;

class KthLargest {
  private PriorityQueue<Integer> minHeap;
  private int k;

  public KthLargest(int k, int[] nums) {
      this.k = k;
      minHeap = new PriorityQueue<>(k);
      for (int num : nums) {
          add(num);
      }
  }
  
  public int add(int val) {
      if (minHeap.size() < k) {
          minHeap.offer(val);
      } else if (val > minHeap.peek()) {
          minHeap.poll();
          minHeap.offer(val);
      }
      return minHeap.peek();
  }
}

/**
 * 要求實現一個數據結構，能夠持續返回數據流中第k大的元素
 * 注意他是排序後第k大的元素，不是第k個不同的元素
 * 
 * 這種找第k大的元素，可以聯想到最小堆的做法（優先隊列）
 * 透過維護一個大小為k的最小堆，其堆頂的元素就是第k大的元素
 * 如果堆的大小小於k時，直接將新元素加入堆中
 * 如果堆已經滿了，並且新元素大於堆頂元素，則彈出堆頂元素，將新元素加入堆中
 * 如此一來，堆頂的元素始終是第k大的元素
 **/