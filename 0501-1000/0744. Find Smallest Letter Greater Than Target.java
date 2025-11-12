// Easy
// Binary Search
// Time: O(logn), Space: O(1)
// https://leetcode.cn/problems/find-smallest-letter-greater-than-target/

class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
      int left = 0, right = letters.length - 1;
      while (left <= right) {
          int mid = (left + right) >> 1;
          if (letters[mid] > target) {
              // the mid might be answer, but we need to keep finding
              // the most left one
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      // if left is exceed the border, means target is bigger than all the elements in array
      // then we return letters[0]
      return letters[left % letters.length];
  }
}
