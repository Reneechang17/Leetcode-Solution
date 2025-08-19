// Medium
// Math
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/number-of-zero-filled-subarrays/

class Solution {
    // It's actually kind of math question...
    // Sum of subarr = n*(n+1)/2
    // But we can just go over and check if it is zero and count it on...easier
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, zeros = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
                res += zeros;
            } else {
                zeros = 0;
            }
        }
        return res;
    }
}
