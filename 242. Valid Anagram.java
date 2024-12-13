// Easy
// Array
// Time:O(m+n),Space:O(1)
// https://leetcode.cn/problems/valid-anagram/

class Solution {
    // Check by ensuring their character counts are the same
    // Use an array to count characters in `s` (increment) and `t` (decrement)
    // If all counts are 0 after processing, they are anagrams
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}
