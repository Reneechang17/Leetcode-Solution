// Medium
// Sliding Window
// Time:O(n),Space:O(k)
// https://leetcode.cn/problems/count-complete-subarrays-in-an-array/

import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int k = set.size();

        int res = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() == k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res += left; // [left-1, right] contains diff elements
        }
        return res;
    }
}
