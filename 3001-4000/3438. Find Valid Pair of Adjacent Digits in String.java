// Easy
// String
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/find-valid-pair-of-adjacent-digits-in-string/

class Solution {
    public String findValidPair(String s) {
        int n = s.length();
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }

        for (int i = 1; i < n; i++) {
            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
            if (c1 != c2) {
                int d1 = c1 - '0', d2 = c2 - '0';
                if (cnt[d1] == d1 && cnt[d2] == d2) {
                    return s.substring(i - 1, i + 1);
                }
            }
        }
        return "";
    }
}
