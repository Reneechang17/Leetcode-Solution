// Easy
// Math
// Time:O(n+m), Space:O(n/m) 
// https://leetcode.cn/problems/greatest-common-divisor-of-strings/

class Solution {
  // Use a recursive approach to find the gcd of two strings:
  // 1. Ensure str1 is always longer or equal to str2 by swapping if necessary
  // 2. If str1 doesn't start with str2, return "" (no gcd possible)
  // 3. If str2 is empty, return str1 (base case)
  // 4. Use a mod-like operation to simulate removing str2's repeated prefix from str1, and recursively call gcdOfStrings
  public String gcdOfStrings(String str1, String str2) {
      if (str1.length() < str2.length()) {
          return gcdOfStrings(str2, str1); // ensure str1 always the longer string
      } 
      if (!str1.startsWith(str2)) {
          return "";
      }
      if (str2.isEmpty()) return str1;
      return gcdOfStrings(str2, mod(str1, str2));
  }
  private String mod(String s1, String s2) {
      while (s1.startsWith(s2)) {
          s1 = s1.substring(s2.length());
      }
      return s1;
  }
}
