// Easy
// Counting
// Time:O(m+n),Space:O(1)
// https://leetcode.cn/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26]; // store each characters

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            cnt[c - 'a']--;
        }

        for (int i : cnt) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
