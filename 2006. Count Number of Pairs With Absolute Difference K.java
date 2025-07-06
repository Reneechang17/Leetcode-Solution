// Easy
// String
// https://leetcode.cn/problems/count-number-of-pairs-with-absolute-difference-k/

import java.util.*;

class Solution2 {
    public int countKDifference(int[] nums, int k) {
        // Optimized: HashMap
        // Time: O(n), Space: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int num : nums) {
            // find num + k & num - k
            cnt += map.getOrDefault(num + k, 0);
            cnt += map.getOrDefault(num - k, 0);

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }
}

class Solution1 {
    public int countKDifference(int[] nums, int k) {
        // Brute force
        // Time: O(n^2), Space: O(1)
        int cnt = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
