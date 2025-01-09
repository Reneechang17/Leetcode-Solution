// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/string-compression/

class Solution {
  // Use two-pointer approach to perform in-place compression of the string
  // Traverse the array with the read pointer to count consecutive characters.
  // Use the write pointer to write the character and its count (if > 1) back into the array.
  public int compress(char[] chars) {
      int write = 0, read = 0;
      while (read < chars.length) {
          char curChar = chars[read];
          int count = 0;
          // count the appear time of curChar
          while (read < chars.length && chars[read] == curChar) {
              read++;
              count++;
          }
          // write the char to res
          chars[write++] = curChar;
          // if the count > 1, add count to res as well
          if (count > 1) {
              for (char c : Integer.toString(count).toCharArray()) {
                  chars[write++] = c;
              }
          }
      }
      return write;
  }
}
