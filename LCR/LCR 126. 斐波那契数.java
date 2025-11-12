// Easy
// DP
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/

class Solution {
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) return n;
        
        int a = 0, b = 0, c = 1;
        for (int i = 2; i <= n; i++) {
            a = b; 
            b = c;
            c = (a + b) % MOD;
        }
        return c;
    }
}
