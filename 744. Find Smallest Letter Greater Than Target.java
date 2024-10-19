// Easy
// Binary Search
// O(logn)
// https://leetcode.cn/problems/find-smallest-letter-greater-than-target/

class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
      // binary search
      int left = 0, right = letters.length - 1;

      while (left <= right) {
          int mid = (left + right) >> 1;

          if (letters[mid] > target) {
              right = mid - 1; // 優先更新右邊界是避免我們錯過更小符合條件的字符
          } else {
              left = mid + 1; // 如果先處理這個條件，可以會錯過一些符合條件的字符
          }
      }
      // 如果最後left超出了數組的長度，則返回數組的第一個字母letters[0],通過left對數組長度取模來實現
      return letters[left % letters.length];
  }
}
