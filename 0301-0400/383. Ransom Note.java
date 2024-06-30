// Easy
// Array, Counting
// O(m + n)
// https://leetcode.com/problems/ransom-note/

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
      if (ransomNote.length() > magazine.length()) {
          return false;
      }
      
      int[] record = new int[26];
      for (char c : magazine.toCharArray()) {
          record[c - 'a'] += 1;
      }

      for (char c : ransomNote.toCharArray()) {
          record[c - 'a'] -= 1;
      }

      for (int i : record) {
          if (i < 0) {
              return false;
          }
      }
      return true;
  }
}

/**
 * base case: 如果贖金信的內容大於雜誌，那不管怎樣都湊不成，直接返回false
 * 思路：分別遍歷贖金信和雜誌，用數組紀錄每個字符出現的元素，只是雜誌用正序計，贖金信用逆序計
 * 然後遍歷紀錄的數組，如果有負數的話，代表湊不齊，返回false
 **/