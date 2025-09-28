// Medium
// Greedy
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int max = nums[0];
        for (int j = 1; j < n; j++) {
            leftMax[j] = max;
            max = Math.max(max, nums[j]);
        }

        int[] rightMax = new int[n];
        int maxRight = nums[n - 1];
        for (int j = n - 1; j >= 0; j--) {
            rightMax[j] = maxRight;
            maxRight = Math.max(maxRight, nums[j]);
        }

        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            long val = (long) (leftMax[j] - nums[j]) * rightMax[j];
            res = Math.max(res, val);
        }

        return res;
    }
}
