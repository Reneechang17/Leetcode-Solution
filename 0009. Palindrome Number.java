// Easy
// Two Pointers
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {
        // basecase: negative are not palindrome
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
