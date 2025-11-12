// Medium
// Bit Manipulation
// Time:O(n * log(max(val))), Space:O(1)
// https://leetcode.cn/problems/minimum-operations-to-make-the-integer-zero/

// The first thought is Greedy... but it is obviously NOT.
// TODO: OK idk.....

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            // calculate sum = num1 - k* num2
            long sum = (long) num1 - (long) k * num2;

            if (sum <= 0)
                continue;

            if (sum < k)
                continue;

            if (Long.bitCount(sum) <= k && k <= sum) {
                return k;
            }
        }
        return -1;
    }
}
