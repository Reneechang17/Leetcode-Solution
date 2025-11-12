// Medium
// Recursion, Math
// Time:O(logn), Space:O(logn)
// https://leetcode.cn/problems/powx-n/

class Solution {
    // Handle negative exponent by converting to positive and calculating the reciprocal
    // Use recursion to calculate x^(n/2), and square the result for even n, multiply by x for odd n
    public double myPow(double x, int n) {
        // if n is negative
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return pow(x, n);
    }
    private double pow(double x, int n) {
        if (n == 0) return 1; // x^0 = 1
        // recursively calculate x^(n/2)
        double half = pow(x, n / 2);

        if (n % 2 == 0) {
            return half * half; // if n is even, return (x^(n/2))^2
        } else {
            return half * half * x; // if n is odd, return (x^(n/2))^2*x
        }
    }
}
