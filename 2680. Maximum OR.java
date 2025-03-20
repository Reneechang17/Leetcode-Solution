// Medium
// Greedy, Suffix Array
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/maximum-or/

class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] suf = new long[n + 1];

        // 后缀数组suf, suf[i]表示nums[i:]的按位或结果
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] | nums[i];
        }

        long res = 0, pre = 0; // pre记录nums[0:i]的按位或结果

        // 对于每个nums[i]，考虑把它左移k位，计算最大按位或结果
        for (int i = 0; i < n; i++) {
            res = Math.max(res, pre | ((long)nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }
        return res;
    }
}
