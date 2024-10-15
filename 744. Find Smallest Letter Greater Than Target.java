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
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      return letters[left % letters.length];
  }
}

/**
 * 尋找比目標字母大的最小字母
 * Note：如果最後left超出了數組的長度，則返回數組的第一個字母letters[0],通過left對數組長度取模來實現
 **/
