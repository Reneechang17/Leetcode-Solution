// Medium
// https://leetcode.cn/problems/binary-subarrays-with-sum/

// 窗口扩大可能会超过goal，缩小可能会小于goal
// 解法1.前缀和+哈希表：如果之前有一个前缀和，使得当前前缀和减去它等于goal
//      那么这些前缀和之间的子数组就是和为goal的子数组
// 解法2. atMost技巧：用atMost(S)-atMost(S-1)

import java.util.*;

class Solution {
    // PredixSum + HashMap
    // Time:O(n), Space:O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0, res = 0;
        for (int x : nums) {
            prefix += x;
            res += map.getOrDefault(prefix - goal, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}

class Solution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, sum = 0, res = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
