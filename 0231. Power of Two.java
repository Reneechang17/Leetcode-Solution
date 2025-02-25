// Easy
// Math
// Time:O(logn), Space:O(logn)
// https://leetcode.cn/problems/power-of-two/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }
}
