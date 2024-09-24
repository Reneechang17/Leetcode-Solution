// Medium
// Priority Queue, Heap
// O(klogk)
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

import java.util.*;

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
      return res;
    }

    // 最小堆存放[nums1[i], nums2[j]]以及其索引i，j
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(
        (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

    // 初始化，放入nums1的每個元素nums2的第一個元素配對
    for (int i = 0; i < nums1.length && i < k; i++) {
      // 存入[nums1[i], nums2[j]]，j=0
      minHeap.offer(new int[] { i, 0 }); // 放入索引
    }

    // 不斷從最小對中取出最小的數對，並加入新的數對
    while (k-- > 0 && !minHeap.isEmpty()) {
      int[] cur = minHeap.poll();
      int i = cur[0], j = cur[1];
      res.add(List.of(nums1[i], nums2[j]));

      // 如果nums2還有下一個元素，則將[nums1[i], nums2[j+1]]放入最小堆
      if (j + 1 < nums2.length) {
        minHeap.offer(new int[] { i, j + 1 });
      }
    }
    return res;
  }
}

/**
 * 找到最小的k個數對
 * 
 * 利用最小堆來解決這個問題，需要維護一個最小堆。每次從堆中彈出和最小的數對，再將與該數對相關的新數對加入堆中，直到找到了 k 個數對
 **/