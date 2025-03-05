// Medium
// String, Greedy
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/break-a-palindrome/

class Solution {
    // Iterate the string and check the pos to make it not palindrome
    //  - modify it to 'a' to make it smaller
    // If no char can be modify, then modify the last one as 'b'
    // Edgecase: if only one char, return null
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        for (int i = 0; i < n / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, n - 1) + 'b';
    }
}
