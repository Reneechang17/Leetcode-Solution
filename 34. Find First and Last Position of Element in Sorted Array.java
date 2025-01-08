// Medium
// Binary Search
// Time: O(logn), Space: O(1)
// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    // Use binary search to find the first and last positions of the target in the sorted array
    // For the first pos, keep searching the left part when nums[mid] == target
    // For the last position, keep searching the right part when nums[mid] == target
    // If the target is not found, return [-1, -1]
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        // make sure we also check when left == right
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                if (nums[mid] == target) index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                if (nums[mid] == target) index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
