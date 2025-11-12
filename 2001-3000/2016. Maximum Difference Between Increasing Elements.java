// Easy
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-difference-between-increasing-elements/

class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = nums[0], maxDiff = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minVal) {
                maxDiff = Math.max(nums[i] - minVal, maxDiff);
            }
            minVal = Math.min(minVal, nums[i]);
        }
        return maxDiff;
    }
}
