// Medium
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    // Use binary search to find the unordered part in partially sorted arr
    //  - nums[mid] > nums[right] -> the smallest val on right side
    //  - nums[mid] <= nums[right] -> on the left side
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

// 在二分查找过程中，每次都排出不包含最小值的一半，当left==right时
// 表示我们已经把搜索范围缩小到唯一元素，这个元素就是旋转数组的最小值
