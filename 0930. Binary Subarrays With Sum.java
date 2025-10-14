// Medium
// https://leetcode.cn/problems/binary-subarrays-with-sum/

import java.util.*;

class Solution {
    // PrefixSum + HashMap
    // Time:O(n), Space:O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;

        for (int x : nums) {
            sum += x;
            res += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

class Solution2 {
    // Sliding Window
    // Time:O(n), Space:O(1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k < 0)
            return 0;
        int left = 0, sum = 0, cnt = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }
}
