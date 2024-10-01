// Medium
// Hash Table, Priority Queue
// O(n logk)
// https://leetcode.cn/problems/top-k-frequent-elements/

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 先用哈希表記錄紀錄每個元素的頻率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 用優先隊列按照頻率升序排序
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 向優先隊列加入元素，一旦元素超過k個，就把小的元素（頻率低的）優先移出
        for (var e : map.entrySet()) {
            que.offer(new int[] {e.getKey(), e.getValue()});
            if (que.size() > k) {
                que.poll();
            }
        }

        // 開一個結果數組，從優先隊列中取出k個元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = que.poll()[0];
        }
        return res;
    }
}

/**
 * 這題是前k個高頻元素
 * 
 * 可以先遍歷數組，用哈希表統計每個元素出現的頻率（key是元素，value是出現的次數）
 * 開一個優先隊列，把頻率升序排序
 * 向優先隊列添加元素，一旦隊列的大小超過k，最小的元素（即頻率最低的元素）將被移除
 * 開一個結果數組，從優先隊列中提取出k個元素，這些是出現頻率最高的前k個元素
 **/