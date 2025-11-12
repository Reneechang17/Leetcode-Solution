// Medium
// DP
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/house-robber-ii/

class Solution {
    // Since houses are arranged in circle, 
    //  -> 1. rob first and no rob last 2. rob last and no rob first
    // DP status is the bigger one of no rob cur(prev status) or rob cur(prev2 + nums[i])
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }
    private int helper(int[] nums, int start, int end) {
        int prev2 = 0, prev = 0, cur = 0;
        for (int i = start; i < end; i++) {
            prev = cur;
            cur = Math.max(prev, prev2 + nums[i]);
            prev2 = prev;
        }
        return cur;
    }
}
