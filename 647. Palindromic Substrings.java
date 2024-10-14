// Medium
// Two Pointers
// O(n^2)
// https://leetcode.cn/problems/palindromic-substrings/

class Solution {
    public int countSubstrings(String s) {
        // 中央擴散法，以中間的字符為中心，向左右擴展，知道不是回文子串
        // 但是要分為字符串長度為奇數/偶數的情況
        int n = s.length(), count = 0;

        for (int i = 0; i < n; i++) {
            // 以i為center，擴展奇數長度的回文子串
            count += helper(s, i, i);
            // 以i & i+1為center，擴展偶數長度的回文子串
            count += helper(s, i, i + 1);
        }
        return count;
    }

    private int helper(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}

// followe up: 也可以用DP做，dp[i][j]表示s[i:j]是否是回文子串
