// Easy
// DP
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/n-th-tribonacci-number/

class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int a = 0, b = 0, c = 1, sum = 1;
        for (int i = 3; i <= n; ++i) {
            a = b;
            b = c;
            c = sum;
            sum = a + b + c;
        }
        return sum;
    }
}
