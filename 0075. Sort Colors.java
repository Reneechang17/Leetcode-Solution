// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1, k = 0;
        while (k <= j) {
            if (nums[k] == 0) {
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[k] == 1) {
                k++;
            } else {
                swap(nums, k, j);
                j--;
                // no need to move k, since we don't
                // know what's color of k right now
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
