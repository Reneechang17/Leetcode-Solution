// Medium
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    // 不管怎么旋转，总会有局部有序的区间
    // 目标是，找到破环左边有序部分的那个点
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // determine which part is sorted
            // 当前mid在左边部分(有序)，但我们要往右边找，找第一个破坏左边有序的位置
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left]; // or nums[right], as left == right
    }
}
