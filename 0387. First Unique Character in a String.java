// Easy
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
