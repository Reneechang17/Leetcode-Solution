// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/valid-palindrome-iv/

class Solution {
    public boolean makePalindrome(String s) { 
        int left = 0, right = s.length() - 1, cnt = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                cnt++;
            }
            left++;
            right--;
        }
        return cnt <= 2;
    }
}
