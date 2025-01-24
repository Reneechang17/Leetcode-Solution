// Easy
// Two Pointers
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/palindrome-number/

class Solution {
    // Convert the integer to String and use Two Pointers to check
    // Use two pointers compare char, if mismatch, return false
    // If pointers meet, the number is palindrome
    public boolean isPalindrome(int x) {
        // Basecase: Negative number are not palindromes
        if (x < 0) return false;
        String s = Integer.toString(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
