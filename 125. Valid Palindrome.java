// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/valid-palindrome/

class Solution {
    // use two pointers to compare
    // before comparing, we need to check if the left or right pointer is point to the valid char
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // skip non-char 
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
