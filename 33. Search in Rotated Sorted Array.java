// Medium
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/search-in-rotated-sorted-array/

class Solution {
    // Search for target in rotated sorted arr using binary search
    // - first to find which part is sorted 
    // - then check if target in that range, and adjust the pointer
    // Repeat until the target is found or the search space is empty
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            // determine which part is sorted
            if (nums[left] <= nums[mid]) {
                // when left part is sorted
                // check if target lies in nums[left]~nums[mid]
                // if so, adjust right pointer
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // when right part is sorted
                // check if target lies in nums[mid]~nums[right]
                // if so, adjust left pointer
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
