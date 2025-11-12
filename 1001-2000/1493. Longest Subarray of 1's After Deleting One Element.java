// Medium
// Sliding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, maxLen = 0, zero = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;
            }

            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
