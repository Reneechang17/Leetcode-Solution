// Medium
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/search-in-rotated-sorted-array/

class Solution {
    // Search for a target in a rotated sorted array using binary search
    // - The key is to determine which part of the array is sorted at each step
    // - If the left part is sorted, check if the target lies within this range. If yes, adjust right; otherwise, adjust left 
    // - If the right part is sorted, check if the target lies within this range. If yes, adjust left; otherwise, adjust right 
    // - Repeat until the target is found or the search space is empty
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;

            // determine sorted part
            // means left part is sorted
            if (nums[left] <= nums[mid]) {
                // if target in nums[left]~nums[mid], adjust right pointer
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // otherwise, adjust left pointer
                    left = mid + 1;
                }
            } else {
                // if target in nums[mid]~nums[right], adjust left pointer
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
