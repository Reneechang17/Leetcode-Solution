// Easy
// Two Pointers
// Time:O(n * m), Space:O(1)
// https://leetcode.cn/problems/find-first-palindromic-string-in-the-array/

class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isValid(s)) {
                return s;
            }
        }
        return "";
    }

    private boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
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
