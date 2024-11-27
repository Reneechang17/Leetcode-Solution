// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/rotate-array/

class Solution {
    // we can first to use k % nums.length -> find the actual rotate steps
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

    public void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
