// Easy
// Hash Table, String
// O(n)
// Similar: 205
// https://leetcode.cn/problems/word-pattern/

import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // 檢查單詞規律 -> 用哈希表來確定映射關係
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) return false;
            } else {
                charToWord.put(c, w);
            }

            if (wordToChar.containsKey(w)) {
                if (!wordToChar.get(w).equals(c)) return false;
            } else {
                wordToChar.put(w, c);
            }
        }
        return true;
    }
}
