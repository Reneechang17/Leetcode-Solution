// Medium
// Math, Map
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/count-number-of-bad-pairs/

import java.util.*;

// I think the prereq for this question is did the good pairs one
// For this question, we'll use total - goods to find bads

// bads = j - i != nums[j] - nums[i]
// => j - nums[j] != i - nums[i] 
// goods => j - nums[j] == i - nums[i] 

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long total = (long) n * (n - 1) / 2;

        Map<Integer, Integer> map = new HashMap<>();
        long goods = 0;

        for (int i = 0; i < n; i++) {
            int diff = i - nums[i];
            goods += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return total - goods;
    }
}
