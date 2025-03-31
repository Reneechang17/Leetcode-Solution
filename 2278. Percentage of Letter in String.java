// Easy
// Math?
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/percentage-of-letter-in-string/

class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) res++;
        }
        return (int)((double)res / n * 100);
    }
}
