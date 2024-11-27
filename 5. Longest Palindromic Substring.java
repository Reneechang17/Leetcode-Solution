// Medium
// Two Pointers
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        // basecase
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        
        // iterate each character in the string as the center
        for (int i = 0; i < s.length(); i++) {
            int oddString = f(s, i, i);
            int evenString = f(s, i, i + 1);
            int len = Math.max(oddString, evenString);

            // if end - start is the cur Longest Palindromic Substring
            // if cur length is larger than the previous one, update the start and end
            if (len > end - start) {
                // (len - 1) / 2 is the length of left part 
                start = i - (len - 1) / 2;
                // len / 2 is the length of right part
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int f (String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // expand the window
            left--;
            right++;
        }
        return right - left - 1;
    }
}
