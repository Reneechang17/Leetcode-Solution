// Easy
// Math
// O(logn)
// https://leetcode.com/problems/ugly-number/

class Solution {
    public boolean isUgly(int n) {
        if (n < 1)
            return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}

/**
 * 醜數：指只包含質因數235的正整數
 * 首先排除小於1的（1也被視為醜數）
 * 看能不能被235除，直到不能被除盡
 * 如果最後n==1，則他的質因數只有235，返回true，如果n ≠ 1，代表他還可以被別的數除盡，就不是醜數
 **/