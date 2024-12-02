// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/next-permutation/

class Solution {
    // 1. Find the first nums[i]<nums[i+1] from the end, which indicate the rightmost ascent
    // 2. Find the first nums[j]>nums[i] from the end and swap them
    // 3. Reverse nums[i+1] to nums[n-1] to get the next smallest permutation
    public void nextPermutation(int[] nums) {
        // Since need to compare nums[i] and nums[i+1], i iterates from the second last
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
