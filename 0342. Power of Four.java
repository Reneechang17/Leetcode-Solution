// Easy
// Bit Manipulation
// Time:O(1),Space:O(1)
// https://leetcode.cn/problems/power-of-four/

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}

// 如果n是4的幂，则n的二进制中有且仅有一个1，这个1出现在从低位开始的第偶数个二进位上
