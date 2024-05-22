// Easy
// Array
// O(n)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // define two pointers at the end of two array(nums1, nums2)
        int i = m - 1, j = n - 1;
        // define a pointer p and point to the end of nums1(bcz we have to fill in
        // nums1)
        int p = nums1.length - 1;
        // compare the i and j
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
        // edge case: make sure the nums2 is iterate over
        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
}
