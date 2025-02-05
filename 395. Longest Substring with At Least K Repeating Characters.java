// Medium
// Divide and Conquer
// Time:O(n^2), Space:O(n) call stack
// https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/

class Solution {
    // Count freq of chars in str, and find first char that doesn't meet the req (count < k)
    // Split string into left and right parts at this char, and recursively solve
    // Return the maximum length from the left and right parts
    public int longestSubstring(String s, int k) {
        // base: if the str is empty or shorter than k, return 0
        if (s == null || s.length() < k) return 0;
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                // divide into left and right
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }
        return s.length();
    }
}

/**
 * 分治思路是如果一個字符串的某個字符出現次數少於k，那麼這個字符就一定不會出現在最終的子串中
 * 因為我們可以將這個字符作為分割點，將原字符串分割成兩部分，然後分別對這兩部分進行遞歸處理
 * 如果所有字符出現的頻率都大於等於k，那麼整個子串就是答案
 **/
