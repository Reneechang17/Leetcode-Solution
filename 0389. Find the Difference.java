// Easy
// XOR, String
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/find-the-difference/

class Solution {
    // XOR a^a=0
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}

class Solution2 {
    public char findTheDifference(String s, String t) {
        String newWord = s + t;
        int[] count = new int[26];
        for (char c : newWord.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
}
