// Easy
// Array
// O(m + n)
// https://leetcode.cn/problems/valid-anagram/

class Solution {
  public boolean isAnagram(String s, String t) {
      // 檢查異位詞：也就是統計兩個字符串每個字符出現的次數是否相等
      // 可以分別遍歷兩次字符串，一次正向紀錄，即對這個字符出現的次數++
      // 一次反向紀錄，即對這個字符出現的次數--
      // 如果是異位詞，最後每個字符出現的次數應該都為0
      int[] count = new int[26];

      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          count[c - 'a']++;
      }

      for (int i = 0; i < t.length(); i++) {
          char c = t.charAt(i);
          count[c - 'a']--;
      }

      for (int i : count) {
          if (i != 0) {
              return false;
          }
      }
      return true;
  }
}
