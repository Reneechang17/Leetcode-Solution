// Medium
// String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/goat-latin/

import java.util.*;

class Solution {
  public String toGoatLatin(String sentence) {
      if (sentence == null || sentence.isEmpty()) return "";
      String[] words = sentence.split(" ");
      StringBuilder res = new StringBuilder();
      Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
      StringBuilder suffix = new StringBuilder("a");

      for (String word : words) {
          if (vowels.contains(word.charAt(0))) {
              res.append(word).append("ma");
          } else {
              res.append(word.substring(1)).append(word.charAt(0)).append("ma");
          }
          res.append(suffix).append(" ");
          suffix.append("a");
      }
      return res.toString().trim();
  }
}
