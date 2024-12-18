// Medium
// Binary Search
// O(logn)
// https://leetcode.cn/problems/find-peak-element/

class Solution {
    // 找峰值+O(logn) -> 二分
    // 峰值的特徵是他會比左右兩邊的元素都大
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
