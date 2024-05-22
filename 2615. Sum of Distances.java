// Medium
// Array, Hash Table, Prefix Sum
// O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[nums.length];
        for (List<Integer> indices : indexMap.values()) {
            long[] prefixSum = new long[indices.size()];
            long[] suffixSum = new long[indices.size()];
            // calculate prefix sum
            for (int i = 1; i < indices.size(); i++) {
                prefixSum[i] = prefixSum[i - 1] + (indices.get(i) - indices.get(i - 1)) * i;
            }
            // calculate suffix sum
            for (int i = indices.size() - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + (indices.get(i + 1) - indices.get(i)) * (indices.size() - 1 - i);
            }
            for (int i = 0; i < indices.size(); i++) {
                ans[indices.get(i)] = (i > 0 ? prefixSum[i] : 0) + (i < indices.size() - 1 ? suffixSum[i] : 0);
            }
        }
        return ans;
    }
}