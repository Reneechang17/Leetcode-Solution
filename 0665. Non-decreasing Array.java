// Medium
// Greedy
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/non-decreasing-array/

class Solution {
    // violation: nums[i] > nums[i + 1]
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                cnt++;
                if (cnt > 1) return false;

                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i]; // modify cur
                } else {
                    nums[i] = nums[i - 1]; // modify prev
                }
            }
        }
        return true;
    }
}
