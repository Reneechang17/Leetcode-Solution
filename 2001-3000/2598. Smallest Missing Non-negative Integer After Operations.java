// Medium
// Array
// Time:O(n), Space:O(value)
// https://leetcode.cn/problems/smallest-missing-non-negative-integer-after-operations/

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // we simplified the infinite ops to limited value's groups
        int[] cnt = new int[value];
        for (int x : nums) {
            int mod = ((x % value) + value) % value;
            cnt[mod]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (cnt[i % value] == 0) {
                return i;
            }
            cnt[i % value]--;
        }
        return nums.length; // we use all number perfectly, so the MEX will be the length of nums itself.
    }
}
