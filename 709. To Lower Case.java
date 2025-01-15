// Easy
// https://leetcode.cn/problems/to-lower-case/

// class Solution {
//     public String toLowerCase(String s) {
//         return s.toLowerCase();
//     }
// }

class Solution {
  public String toLowerCase(String s) {
      int diff = 'A' - 'a';
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
          if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] -= diff;
      }
      return String.valueOf(chars);
  }
}
