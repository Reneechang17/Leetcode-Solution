// Hard
// Sliding Window
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/

class Solution {
    // the key is to maintain the boundary
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long res = 0;

        int leftBound = -1, lastMin = -1, lastMax = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) lastMin = i;
            if (nums[i] == maxK) lastMax = i;

            int left = Math.min(lastMin, lastMax);
            if (left > leftBound) {
                res += left - leftBound;
            }
        }
        return res;
    }
}
