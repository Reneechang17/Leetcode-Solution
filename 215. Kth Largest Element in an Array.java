// Medium
// QuickSelect
// Time:O(n)for average, O(n^2) for worse
// Space:O(logn) for average, O(n) for worse
// https://leetcode.cn/problems/kth-largest-element-in-an-array/

class Solution {
    // Find the k-th largest element by locating the n-k smallest element
    // Use QuickSelect to partition the arr around the pivot, split the arr into two part
    // Recursively focus on the side contain the target index(n-k)
    // Stop when the pivot matches the target index, return the element at this pos
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[(left + right) >> 1];
        int i = left, j = right;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        // determine which part contain k (target)
        // left
        if (k <= j) {
            return quickSelect(nums, left, j, k);
        }
        // right
        if (k >= i) {
            return quickSelect(nums, i, right, k);
        }
        // if the pivot element is equal to k, return the pivot
        return nums[k];
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
