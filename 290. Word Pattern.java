// Easy
// Hash Table, String
// O(n)
// Similar: 205
// https://leetcode.com/problems/word-pattern/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean wordPattern(String pattern, String s) {
      String[] words = s.split(" ");
      if (words.length != pattern.length()) return false;

      Map<Character, String> charToWord = new HashMap<>();
      Map<String, Character> wordToChar = new HashMap<>();

      for (int i = 0; i < pattern.length(); i++) {
          char c = pattern.charAt(i);
          String word = words[i];

          if (charToWord.containsKey(c)) {
              if (!charToWord.get(c).equals(word)) return false;
          } else {
              charToWord.put(c, word);
          }

          if (wordToChar.containsKey(word)) {
              if (wordToChar.get(word) != c) return false;
          } else {
              wordToChar.put(word, c);
          }
      }
      return true;
  }
}

/**
 * 檢查字符串是否符合給定的模式排列：這題和205的檢查同構類似，核心任務都檢查映射關係，確保模式中的每個字符都唯一對應到字符串中的一個單詞
 * 一樣使用兩個哈希表來檢查映射關係
 **/