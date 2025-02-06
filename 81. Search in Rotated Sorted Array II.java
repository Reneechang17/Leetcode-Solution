// Medium
// Binary search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // left part is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // search left side
                } else {
                    left = mid + 1; // search right side
                }
            }
            // right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // search right side
                } else {
                    right = mid - 1; // search left side
                }
            }
        }
        return false;
    }
}

// 这题和33不同在于有重复元素，当nums[mid]==nums[left]==nums[right]时
// 无法判断哪一半是有序的，只能线性跳过left++ or right--
