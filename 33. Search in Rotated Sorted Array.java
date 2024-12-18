// Medium
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/search-in-rotated-sorted-array/

class Solution {
    // O(logn)->binary search
    // Given a rotated array, but no matter how it is rotated
    // one part of the array will always be sorted.
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // determine the sorted part
            // nums[left] <= nums[mid] means the left part is sorted
            if (nums[left] <= nums[mid]) {
                // if target in nums[left]-nums[mid], adjust right pointer
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // if target in nums[mid]-nums[right], adjust left pointer
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
