// Medium
// Binary Search
// Time:O(logn), Space:O(1)
// https://leetcode.cn/problems/find-peak-element/
// 题解：https://leetcode.cn/problems/find-peak-element/solutions/1987497/by-endlesscheng-9ass/?envType=study-plan-v2&envId=top-interview-150

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
