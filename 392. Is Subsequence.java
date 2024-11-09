// Easy
// Two Pointers
// O(n + m)
// https://leetcode.cn/problems/is-subsequence/

class Solution {
    public boolean isSubsequence(String s, String t) {
        // i go through s, j go through t
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++; // whether it match or not, j need to move
        }

        return i == s.length();
    }
}
