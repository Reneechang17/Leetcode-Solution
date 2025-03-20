// Medium
// Stack, Greedy
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-string-balanced/

class Solution {
    public int minSwaps(String s) {
        int n = s.length(), cnt = 0;
        StringBuilder sb = new StringBuilder(s);
        int stack = 0, p = n - 1;
        for (int i = 0; i < n; i++) {
            char c = sb.charAt(i);
            if (c == '[') {
                stack++;
            } else {
                if (stack > 0) {
                    stack--;
                } else {
                    // find the rightmost '[' and swap
                    while (sb.charAt(p) != '[') {
                        p--;
                    }
                    sb.setCharAt(p, ']');
                    cnt++;
                    stack++;
                }
            }
        }
        return cnt;
    }
}
