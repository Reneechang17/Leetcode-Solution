// Easy
// Math
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/check-balanced-string/

class Solution {
    public boolean isBalanced(String num) {
        int even = 0, odd = 0;
        for (int i = 0; i < num.length(); i++) {
            int x = num.charAt(i) - '0';
            if (i % 2 == 0) {
                even += x;
            } else {
                odd += x;
            }
        }
        return even == odd;
    }
}
