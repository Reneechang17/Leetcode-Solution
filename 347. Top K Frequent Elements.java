// Medium
// Priority Queue
// Time:O(nlogk), Space:O(m + k)
// https://leetcode.cn/problems/top-k-frequent-elements/

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use map to record the frequency of the element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // use priority queue to maintain top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        // extract the top k elements from the pq
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
