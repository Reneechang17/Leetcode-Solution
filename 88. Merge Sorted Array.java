// Easy
// Array
// O(n)
// https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 可以直接用一個指針往nums1填充，定義雙指針從後面往前遍歷填充
        int i = m - 1, j = n - 1, p = m + n - 1;

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
        // 避免nums1走完，nums2沒走完的情況
        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
}

/**
 * 思路：直接往nums1填充
 * 定義雙指針，分別指向nums1和nums2的結尾，指針p指向合併後的數組的末尾
 * 對i & j比大小，從後向前遍歷，誰大先往nums1[p]中填誰
 * Note：要注意p也要--
 * 
 * edge case：為了確保nums2有走完，避免nums1已經走完，但是nums2還沒走完的情況（example3的情況）
 **/
