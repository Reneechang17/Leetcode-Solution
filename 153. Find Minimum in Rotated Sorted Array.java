// Medium
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    // Use binary search to find the point where the sorted portion is disrupted
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // determine which part is sorted
            // nums[mid] > nums[right], the min must be to the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left]; // or nums[right], as left == right
    }
}
