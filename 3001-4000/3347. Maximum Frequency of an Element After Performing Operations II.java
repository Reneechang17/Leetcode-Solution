// Hard
// Binary Search
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-ii/

// The difference with 3346 is the dataset for this problem is larger.

import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> candidates = new TreeSet<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            candidates.add(x);
            candidates.add(x - k);
            candidates.add(x + k);
        }

        int maxFreq = Collections.max(map.values());

        for (int c : candidates) {
            int left = lower(nums, c - k);
            int right = upper(nums, c + k);
            int inRange = right - left;

            if (map.containsKey(c)) {
                maxFreq = Math.max(maxFreq, Math.min(inRange, map.get(c) + numOperations));
            } else {
                maxFreq = Math.max(maxFreq, Math.min(inRange, numOperations));
            }
        }
        return maxFreq;
    }

    private int lower(int[] nums, long value) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= value)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upper(int[] nums, long value) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= value)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
