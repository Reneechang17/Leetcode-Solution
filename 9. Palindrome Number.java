// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/palindrome-number/

class Solution {
    // first the negative number will not be palindrome number
    // and we can turn the integer to string
    // then use two pointers, one point to first element, one point to last element
    // and check if the elements they point are the same
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

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
