// Medium
// Binary Search
// O(logn)
// https://leetcode.cn/problems/find-peak-element/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * 找數組中的峰值，用二分查找
 * 峰值會比他左右兩側的值都大 即nums[i] > nums[i - 1] && nums[i] > nums[i + 1]
 **/