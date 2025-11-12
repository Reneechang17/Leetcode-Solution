// Medium
// Math
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/count-number-of-homogenous-substrings/

class Solution {
    public int countHomogenous(String s) {
        final int MOD = 1_000_000_007;
        long res = 0;

        char curChar = s.charAt(0);
        int cnt = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == curChar) {
                cnt++;
            } else {
                res = (res + (long) cnt * (cnt + 1) / 2) % MOD;
                // reset
                curChar = s.charAt(i);
                cnt = 1;
            }
        }
        // deal last pair
        res = (res + (long) cnt * (cnt + 1) / 2) % MOD;
        return (int) res;
    }
}

/**
 * 如果有n个连续相同的字符，这些字符可以形成的同构子字符串数量是n*(n+1)/2
 * 例如"aaa"，可以形成"a","a","a","aa","aa","aaa"，总共3*(3+1)/2=6个
 */
