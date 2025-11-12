// Medium
// Priority Queue
// O(klogk)
// https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/

import java.util.*;

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<List<Integer>> res = new ArrayList<>();

      // base
      if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
          return res;
      }

      // 最小堆中存儲的是[sum, i, j]
      PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

      // 初始化堆，加入nums1[0]和nums[j]的組合
      for (int j = 0; j < nums2.length && j < k; j++) {
          minHeap.offer(new int[]{nums1[0] + nums2[j], 0, j});
      }

      // 取前k個最小的組合
      while (k > 0 && !minHeap.isEmpty()) {
          int[] top = minHeap.poll();
          int i = top[1], j = top[2];

          res.add(Arrays.asList(nums1[i], nums2[j])); // 將當前組合加進去

          // 如果nums1中還有下一個元素
          if (i + 1 < nums1.length) {
              minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
          }
          k--;
      }
      return res;
  }
}
