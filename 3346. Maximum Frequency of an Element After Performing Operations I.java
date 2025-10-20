// Medium
// Difference Array
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-i/

// Can learn with Leetcode 1838, this question can be solved by Sliding Window cause it 
// stays monotonicity(only plus ops); but 3346 can be two-way adjust, so we can't make sure
// the target(maxOps), so we use Difference Array to find the "adjustable range".

import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> diff = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            diff.put(x - k, diff.getOrDefault(x - k, 0) + 1);
            diff.put(x + k + 1, diff.getOrDefault(x + k + 1, 0) - 1);
        }

        Set<Integer> all = new HashSet<>();
        all.addAll(diff.keySet());
        all.addAll(freq.keySet());

        List<Integer> list = new ArrayList<>(all);
        Collections.sort(list);

        int maxFreq = 0, cur = 0;

        for (int l : list) {
            cur += diff.getOrDefault(l, 0);
            int exist = freq.getOrDefault(l, 0);
            int canChange = cur - exist;
            maxFreq = Math.max(maxFreq, exist + Math.min(canChange, numOperations));
        }
        return maxFreq;
    }
}
