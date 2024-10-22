// Easy
// String
// brute force -> O(m*n), KMP -> O(m+n)
// https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution {
  // 找出haystack中第一次出現needle的位置，如果不存在返回-1
  // 這題可以用暴力匹配orKMP，以下用暴力（因為數據量不大，而且只需要返回第一個出現的起始位置
  public int strStr(String haystack, String needle) {
      int m = haystack.length(), n = needle.length();

      if (n == 0) {
          return 0;
      }

      // 遍歷haystack的每一個可能的開始位置
      for (int i = 0; i <= m - n; i++) {
          // 檢查從i開始的substring是否和needle相等
          int j = 0;
          while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
              j++;
          }

          // 如果完全匹配，就返回i
          if (j == n) {
              return i;
          }
      }
      return -1;
  }
}
