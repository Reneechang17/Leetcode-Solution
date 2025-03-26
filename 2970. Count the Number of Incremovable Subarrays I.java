// Easy
// Brute Force, Two Pointers
// Time:O(n²),Space:O(1)
// https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/

class Solution {
    // Check all possible nums[i:j], see if remove nums[i:j], remain part is
    // increase
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isIncreasing(nums, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isIncreasing(int[] nums, int left, int right) {
        for (int i = 1; i < nums.length; i++) {
            if (i >= left && i <= right + 1)
                continue; // skip[left, right] subset
            if (nums[i] <= nums[i - 1])
                return false;
        }
        // check boundary
        if (left - 1 >= 0 && right + 1 < nums.length && nums[right + 1] <= nums[left - 1]) {
            return false;
        }
        return true;
    }
}
