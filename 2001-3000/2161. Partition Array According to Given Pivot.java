// Medium
// Two Pointers
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/partition-array-according-to-given-pivot/

import java.util.Arrays;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, pivot);

        int left = 0, right = n - 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) {
                res[left] = nums[i];
                left++;
            }
            if (nums[j] > pivot) {
                res[right] = nums[j];
                right--;
            }
        }
        return res;
    }
}
