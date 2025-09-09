// Easy
// Simulation
// Time:O(n * logn), Space:O(1)
// https://leetcode.cn/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (!String.valueOf(a).contains("0") &&
                    !String.valueOf(b).contains("0")) {
                return new int[] { a, b };
            }
        }
        return new int[] {};
    }
}
