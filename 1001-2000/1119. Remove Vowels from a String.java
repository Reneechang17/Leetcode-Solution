// Easy
// String
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/remove-vowels-from-a-string/

class Solution {
  public String removeVowels(String s) {
      StringBuilder sb = new StringBuilder();
      for (char c : s.toCharArray()) {
          if ("aeiou".indexOf(c) == -1) {
              // not vowel, add to sb
              sb.append(c);
          }
      }
      return sb.toString();
  }
}
