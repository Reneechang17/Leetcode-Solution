// Easy
// Array
// Time:O(m+n),Space:O(1)
// https://leetcode.cn/problems/valid-anagram/

class Solution {
    // Means the number of each char in s and t should be same
    // we can use an array to check, but for s, it will plus, for t, it will minus
    // finally, we can check if all the char are remain 0, if so return true
    // otherwise, it means that they are not an anagram
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
