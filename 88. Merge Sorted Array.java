// Easy
// Two Pointers
// Time:O(m+n), Space:O(1)
// https://leetcode.cn/problems/merge-sorted-array/

class Solution {
    // Merge two sorted arrays (nums1 and nums2) into nums1 in-place.
    // 1. Use two pointers to traverse nums1 and nums2 from the end.
    // 2. Compare elements from the back and place the larger one at the end of nums1.
    // 3. If nums2 still has remaining elements, fill them in nums1.
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
