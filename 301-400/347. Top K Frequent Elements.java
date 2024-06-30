// Medium
// Hash Table, Heap(Priority Queue)
// O(n logk)
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> count = new HashMap<>();
      for (int v : nums) {
          count.put(v, count.getOrDefault(v, 0) + 1);
      }
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
      for (var e : count.entrySet()) {
          pq.offer(new int[] {e.getKey(), e.getValue()});
          if (pq.size() > k) {
              pq.poll();
          }
      }
      int[] ans = new int[k];
      for (int i = 0; i < k; i++) {
          ans[i] = pq.poll()[0];
      }
      return ans;
  }
}

/**
 * 這題是前k個高頻元素
 * 
 * 可以先遍歷數組，用哈希表統計每個元素出現的頻率（key是元素，value是出現的次數）
 * 開一個優先隊列，把頻率升序排序
 * 向優先隊列添加元素，一旦隊列的大小超過k，最小的元素（即頻率最低的元素）將被移除
 * 來一個結果數組，從優先隊列中提取出k個元素，這些是出現頻率最高的前k個元素
 **/