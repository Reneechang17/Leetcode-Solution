// Easy
// Iteration
// Time:O(nk),Space:O(1)
// https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-i/

import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i <= n - 2 * k; i++) {
            if (isValid(nums, i, k) && isValid(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(List<Integer> nums, int start, int k) {
        for (int i = start + 1; i < start + k; i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
