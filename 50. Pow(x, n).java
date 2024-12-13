// Medium
// Math
// Time:O(log N), Space:O(1)
// https://leetcode.cn/problems/powx-n/

class Solution {
    // Use fast exponentiation to calculate x^n efficiently
    // If n is negative, take the reciprocal of x and use -n
    // Iterate through the binary representation of n to multiply the base (cur) when the current bit is 1
    // Square the base (cur) at each step to handle the next power of 2
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double cur = x;
        // 每次將n對半處理
        // 如果n是偶數 -> x^n = x^n/2 * x^n/2
        // 如果n是奇數 -> x^n = x * x^(n - 1)/2 * x^(n - 1)/2
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans *= cur;
            }
            cur *= cur;
        }
        return ans;
    }
}
