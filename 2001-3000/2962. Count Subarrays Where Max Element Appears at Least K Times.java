// Medium
// Sliding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            max = Math.max(x, max);
        }

        long res = 0;
        int left = 0, cnt = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) cnt++;
            while (cnt >= k) {
                res += nums.length - right;

                if (nums[left] == max) {
                    cnt--;
                }
                left++;
            }
        }
        return res;
    }
}
