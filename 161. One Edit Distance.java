// Medium
// Two Pointers
// O(n)
// https://leetcode.com/problems/one-edit-distance/

class Solution {
  public boolean isOneEditDistance(String s, String t) {
      int sLen = s.length(), tLen = t.length();

      if (sLen > tLen) {
        String tmp = s;
        s = t;
        t = tmp;
        sLen = s.length();
        tLen = t.length();
    }

      if (tLen - sLen > 1) return false;

      for (int i = 0; i < sLen; i++) {
          if (s.charAt(i) != t.charAt(i)) {
            if (sLen == tLen) {
                // 如果長度相同，看剩餘的部分是否相同
                  return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                // 如果長度不同，就看短的字符串剩餘部分是否等於長字符串的下一部分
                  return s.substring(i).equals(t.substring(i + 1));
              }
          }
      }
      return (sLen + 1 == tLen);
  }
}

/**
 * 一次編輯距離:要求判斷兩個字符串是否相差一次編輯距離（插入、刪除、替換）可以變成相同
 * 
 * 屬於編輯距離的變形，只需要判斷是否相差一次編輯距離即可
 * 對於這個問題，可以根據字符串的長度和內容來判斷：
 * 1. 如果字符串的長度差大於1，則返回false，因為不可能通過一次編輯使得兩個長度差大於1的字符串相同
 * 2. 如果長度相等，可以檢查有多少位置不同，如果只有一個位置不同，則返回true
 * 3. 如果長度差為1，可以通過一次插入或是刪除操作使得兩個字符串相同，需要檢查較短的字符串是否可以通過一次插入或是刪除變成較長的字符串
 **/