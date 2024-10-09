// Medium
// Math
// O(log N)
// https://leetcode.cn/problems/powx-n/

class Solution {
    public double myPow(double x, int n) {
        // 取x的n次冪
        long N = n;

        // 如果n為負數，就把x轉成倒數
        // 並將n取正
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
