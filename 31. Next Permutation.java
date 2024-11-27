// Medium
// Array, Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/next-permutation/

class Solution {
    // 1. From end to start, find the first nums[i]<nums[i+1]->nums[i+1]-nums[n-1] is in descending order
    // 2. If find i, find the first num nums[j] greater than nums[i] from the back to the front, and swap them
    // 3. Reverse nums[i+1]-nums[n-1], so that the new sequence obtained is the smallest of all permutations greater than the original sequence
    public void nextPermutation(int[] nums) {
        // Since we need to compare nums[i] and nums[i+1], i iterates from the second last
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
