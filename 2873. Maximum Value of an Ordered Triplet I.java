// Easy
// Brute Force
// Time:O(n^3),Space:O(1)
// https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-i/

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    res = Math.max(res, (long)(nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return res;
    }
}
