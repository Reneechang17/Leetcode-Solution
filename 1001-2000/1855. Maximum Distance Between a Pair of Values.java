// Medium
// Two Pointers
// Time:O(m+n),Space:O(1)
// https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0, i = 0, m = nums1.length, n = nums2.length;
        for(int j = 0; j < n; j++) {
            // find the smallest i
            while (i < j && i < m && nums1[i] > nums2[j]) {
                i++;
            }
            if (i < m && nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
            }
        }
        return maxDist;
    }
}
