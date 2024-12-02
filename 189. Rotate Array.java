// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/rotate-array/

class Solution {
    // Use k % n to get the actual rotate steps
    // as rotate n times or more results in the same array
    // reverse the whole nums
    // reverse first k elements
    // reverse n - k elements
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
