// Easy
// Brute Force
// Time:O(n^2),Space:O(1)
// https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-i/

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int k = 2; k < n; k++) {
            int m = nums[0];
            for (int j = 1; j < k; j++) {
                res = Math.max(res, (long)(m - nums[j]) * nums[k]);
                m = Math.max(m, nums[j]);
            }
        }
        return res;
    }
}
