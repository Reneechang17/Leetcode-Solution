// Easy
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/first-unique-character-in-a-string/

class Solution {
    // Since it only contains lowercase, so use arr to count the appear time of each char
    // Then iterate the string again, if char occur 1, return its index 
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
