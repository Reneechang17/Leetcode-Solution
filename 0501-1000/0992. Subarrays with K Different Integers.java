// Hard
// Sliding Window
// Time:O(n), Space:O(k)
// https://leetcode.cn/problems/subarrays-with-k-different-integers/

import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // 刚好k个不同整数 = 最多k个不同整数-最多k-1个不同整数
        // 可以用map或计数数组做
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
