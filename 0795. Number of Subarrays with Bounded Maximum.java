// Medium
// Math
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 最大元素大于等于left&&小于等于right的子数组个数 =
        // 最大元素小于等于right的子数组个数 - 最大元素小于left的子数组个数
        return helper(nums, right) - helper(nums, left - 1);
    }

    private int helper(int[] nums, int max) {
        int ret = 0, cntSubarr = 0;
        for (int num : nums) {
            if (num <= max) {
                cntSubarr++;
                ret += cntSubarr;
            } else {
                cntSubarr = 0;
            }
        }
        return ret;
    }
}
