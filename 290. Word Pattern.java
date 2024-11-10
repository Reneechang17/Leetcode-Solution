// Easy
// Hash Table
// O(n)
// Similar: 205
// https://leetcode.cn/problems/word-pattern/

import java.util.*;

class Solution {
    // we can use map to check there relationship
    // one map is mapping the char to word
    // another map is mapping the word to char
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        // basecase
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>(); // store char to word
        Map<String, Character> wordToChar = new HashMap<>(); // store word to char

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            // check if the charToWord contains the c
            // if so, check if the mapping word is equal to w
            // otherwise, put the c and w to map
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) {
                    return false;
                }
            } else {
                charToWord.put(c, w);
            }

            // also check if wordToChar contains the w
            if (wordToChar.containsKey(w)) {
                if (!wordToChar.get(w).equals(c)) {
                    return false;
                }
            } else {
                wordToChar.put(w, c);
            }
        }
        return true;
    }
}
