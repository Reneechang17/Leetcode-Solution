// Medium
// Sliding Window
// Time:O(n),Space:O(k)
// https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/

import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return 0;
        long curSum = 0, maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            curSum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // if window size > k
            if (right - left + 1 > k) {
                curSum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            // deal duplicate element
            while (map.getOrDefault(nums[right], 0) > 1) {
                curSum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }
}
