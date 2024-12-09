// Easy
// Array, Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/merge-sorted-array/

class Solution {
    // we can finally modify on nums1 using a pointer
    // and use the two pointers to go through the nums1 and nums2 from the end
    // since they are sorted array, we can start from fill out the biggest element
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1,  j = n - 1, p = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else {
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }

        // if we done the nums1, but nums2 still have element
        // then we fill the nums2 in remain space
        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
}
