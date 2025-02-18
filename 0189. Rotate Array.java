// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/rotate-array/

class Solution {
    // Use k % n to get the actual rotate steps
    // as rotate n times or more results in the same arr
    // reverse the whole arr
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

// dryrun
// Input: nums = [-1,-100,3,99], k = 2
// n = 4, k = 2 % 4 = 2
// This ensures we only rotate within the bounds of the array size
// reverse nums[0]~nums[3] -> [99,3,-100,-1]
// reverse nums[0]~nums[1] -> [3,99,-100,-1]
// reverse nums[2]~numd[3] -> [3,99,-1,-100]
