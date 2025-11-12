// Medium
// https://leetcode.cn/problems/top-k-frequent-elements/

import java.util.*;

class Solution {
    // Use HashMap to count frequencies and minHeap to track top-k frequent elements
    // 1. Count the frequency of each element using a HashMap
    // 2. Use a min-heap (PriorityQueue) to keep the k most frequent elements
    // 3. If the heap size exceeds k, remove the least frequent element
    // 4. Extract elements from the heap to form the result
    // Time:O(nlogk),Space:O(N+K)
    // 适用于k相对小，n较大的时候
    public int[] topKFrequent(int[] nums, int k) {
        // use map to record the freq of elements <num, freq>
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        // put each key-val pairs to pq and check if size > k
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}

class Solution2 {
    // sort+get topk
    // Time:O(nlogn),Space:O(n)
    // 适用于k比较接近n时，如果k比较小，其他方法更有效
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}

class Solution3 {
    // bucketSort: build bucket, size is n+1. Each pos store the element has same Freq
    // iterate the bucket from high freq to low freq, collect topk
    // Time:O(n),Space:O(n)
    // 适用于k接近n、以及频率比较集中的情况
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        @SuppressWarnings("unchecked") // just remove warning
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        // put the element to corresponding bucket
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int freq = e.getValue();
            bucket[freq].add(e.getKey());
        }
        // collect topk from high freq to low freq
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            for (int num : bucket[i]) {
                res.add(num);
                if (res.size() == k) break;
            }
        }
        // to array
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}

class Solution4 {
    // QuickSelect: map to record the freq, and transfer it to an arr
    // each element in arr is element-freq pair, and use quickselect to get topk
    // Time:O(n), the worse is O(n^2), Space:O(n)
    // 适用于k远小于n的时候
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // put the freq to arr
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // use quick select to get topk
        quickSelect(list, 0, list.size() - 1, k);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
    private void quickSelect(List<Map.Entry<Integer, Integer>> list, int left, int right, int k) {
        if (left >= right) return;
        int pivotIndex = partition(list, left, right);
        if (pivotIndex == k) return;
        else if (pivotIndex < k) quickSelect(list, pivotIndex + 1, right, k);
        else quickSelect(list, left, pivotIndex - 1, k);
    }
    private int partition(List<Map.Entry<Integer, Integer>> list, int left, int right) {
        Map.Entry<Integer, Integer> pivot = list.get(right);
        int pivotValue = pivot.getValue();
        int i = left;
        for (int j = left; j < right; j++) {
            if (list.get(j).getValue() > pivotValue) {
                Collections.swap(list, i, j);
                i++;
            }
        }
        Collections.swap(list, i, right);
        return i;
    }
}
