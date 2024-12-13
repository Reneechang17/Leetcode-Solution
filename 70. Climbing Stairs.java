// Easy
// DP
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/climbing-stairs/

class Solution {
    // Use DP idea to do, for basecase, 1step -> 1way, 2steps -> 2 ways
    // From step 3 onward, the number of ways is the sum of the way to climb the prev two steps
    // Iterate to update the two prev steps(a and b) until reach n
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b; // the total ways for n steps
    }
}
