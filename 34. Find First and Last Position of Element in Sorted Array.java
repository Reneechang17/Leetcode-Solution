// Medium
// Binary Search
// Time: O(logn), Space: O(1)
// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    // we need to find the first and last position of target
    // if the target appear many times, we need to return the most left and most right one
    // we can use the binary search to do this, but we cannot directly return the mid value 
    // we need to keep adjusting the left and right to find the most edge one
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                // we need to put the equal here, so that we can keep find the left part
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
                // same here, we need to keep finding the right part
                if (nums[mid] == target) index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
