// Medium
// Sliding Window
// O(n)
// https://leetcode.cn/problems/minimum-size-subarray-sum/

class Solution {
    // to find the subarray, we can use sliding window
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0;
        int res = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            // since we need to find the min size
            // so once the sum is bigger than target, we need to calculate the size
            // and to shrink the window (move i pointer)
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// Also can use prefix sum method
