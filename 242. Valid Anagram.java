// Easy
// Hash Table, Array, String
// O(m + n)
// https://leetcode.com/problems/valid-anagram/

class Solution {
  public boolean isAnagram(String s, String t) {
    int[] record = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      int idx = cur - 'a';
      int cntCurIdx = record[idx];
      cntCurIdx++;
      record[idx] = cntCurIdx;
    }

    for (int i = 0; i < t.length(); i++) {
      char cur = t.charAt(i);
      int idx = cur - 'a';
      int cntCurIdx = record[idx];
      cntCurIdx--;
      record[idx] = cntCurIdx;
    }

    for (int count : record) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
}

/**
 * 異位詞：數組統計每個字母出現的次數
 * 為了確定兩個字符串是否為異位詞，可以分別遍歷兩個字符串，但是一個正向紀錄，一個逆向紀錄
 * 最後遍歷數組，如果是異位詞，計數值應該是0
 **/