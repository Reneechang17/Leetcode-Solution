// Easy
// Array
// O(n)
// https://leetcode.cn/problems/first-unique-character-in-a-string/

class Solution {
  public int firstUniqChar(String s) {
      // 先記錄每個字符出現的次數 -> 數組
      // 遍歷這個字符串，如果當前字符出現的次數等於1直接返回
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
