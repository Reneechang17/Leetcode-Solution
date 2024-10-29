// Easy
// Binary Search
// O(logn)
// https://leetcode.cn/problems/find-smallest-letter-greater-than-target/

class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
      // binary search
      int left = 0, right = letters.length - 1;

      // 確保left==right的那個mid也可以檢查到
      // 因為要找大於target的最小字符，所以要不斷調整left和right來找
      while (left <= right) {
          int mid = (left + right) >> 1;

          if (letters[mid] > target) {
            // 這個mid可能是我們想要的，或者我們還可以在mid的左邊找到更小的字符
              right = mid - 1; 
          } else {
            // 說明mid不符合要求，需要在mid的右邊找
              left = mid + 1; 
          }
      }
      // 如果最後left超出了數組的長度，說明target比數組的所有字符都大
      // 則返回數組的第一個字母letters[0],通過left對數組長度取模來實現
      return letters[left % letters.length];
  }
}
