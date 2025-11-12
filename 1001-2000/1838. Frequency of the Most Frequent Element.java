// Medium
// Sliding Window
// Time:O(nlogn), Space:O(1)
// https://leetcode.cn/problems/frequency-of-the-most-frequent-element/

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, maxFreq = 1;
        long ops = 0;
        for (int right = 0; right < nums.length; right++) {
            if (right > 0) {
                long diff = nums[right] - nums[right - 1];
                ops += diff * (right - left);
            }

            while (ops > k) {
                ops -= nums[right] - nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}
