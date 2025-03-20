// Medium
// Sliding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/2VG8Kg/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, left = 0, curSum = 0, minLen = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                curSum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
