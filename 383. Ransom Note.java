// Easy
// Counting
// O(m + n)
// https://leetcode.cn/problems/ransom-note/

class Solution {
    // we can use an array to check each char's appear time in note and magazine
    // but for magazine, we calculate in positive, and for note, we calculate in negative
    // finally we can iterate the record, if any char is negative, means we cannot build it
    public boolean canConstruct(String ransomNote, String magazine) {
        // basecase: if the ransomNote's length > magazine -> we cannot construct the note
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
