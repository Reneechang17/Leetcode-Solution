// Medium
// Array, Binary Search
// O(n logn)
// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * 思路：雙指針+二分查找
 * 先找mid，再遍歷nums，有多少個num小於等於mid
 * 如果小於mid的數量大於mid，代表這個duplicate number在左側， 否則在右側
 **/