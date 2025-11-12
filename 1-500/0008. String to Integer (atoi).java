// Medium
// Math
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/string-to-integer-atoi/

class Solution {
  // Skip leading whitespace, and handle optional sign('+'or'-')
  // Parse digits and accumulate res, then check overflow 
  public int myAtoi(String s) {
      int index = 0, sign = 1, num = 0, n = s.length();
      while (index < n && s.charAt(index) == ' ') index++;

      if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
          sign = (s.charAt(index) == '-') ? -1 : 1;
          index++;
      }

      while (index < n && Character.isDigit(s.charAt(index))) {
          int digit = s.charAt(index) - '0';
          // check overflow
          if (num > (Integer.MAX_VALUE - digit) / 10) {
              return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
          }
          num = num * 10 + digit;
          index++;
      }
      return num * sign;
  }
}
