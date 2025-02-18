// Medium
// Sliding Window
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/minimum-size-subarray-sum/

class Solution {
    // Use sliding window to find the smallest subarray where sum >= target
    // Expand window with right pointer until sum >= target,
    //   then shrink it by moving the left pointer i
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // if sum fit the req(target), try to shrink window
            // and update size
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// Also can use prefix sum method
