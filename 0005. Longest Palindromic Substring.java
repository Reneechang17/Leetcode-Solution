// Medium
// Two Pointers
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/longest-palindromic-substring/

class Solution {
    // Iterate each char in the string as a potential center of a palindrome
    // Expand the center for both odd and even palindromes to find max length
    // Update start and end index of the longest palindrome based on the calculated length
    // Return the substring within the determined range [start, end]
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddString = f(s, i, i);
            int evenString = f(s, i, i + 1);
            int len = Math.max(oddString, evenString);

            // if end - start is the cur longest palindromic substring
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
            left--;
            right++;
        }
        return right - left - 1;
    }
}
