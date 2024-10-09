// Hard
// String
// O(n)
// https://leetcode.cn/problems/valid-number/

class Solution {
  public boolean isNumber(String s) {
      // 去掉字符串两端的空格
      s = s.trim();
      if (s.length() == 0) {
          return false;
      }

      boolean isDigit = false; 
      boolean isDot = false;
      boolean isE = false;
      boolean numberAfterE = true; // 指數符號e或是E之後是否有數字

      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);

          if (Character.isDigit(c)) {
              isDigit = true;
              numberAfterE = true;
          } else if (c == '.') {
              // 小數點只能出現一次，且不能在e和E之後出現
              if (isDot || isE) {
                  return false;
              }
              isDot = true;
          } else if (c == 'e' || c == 'E') {
              // 如果e已經出現或是前面沒有數字，直接返回false
              if (isE || !isDigit) {
                  return false;
              }
              isE = true;
              numberAfterE = false; // e之後必須有數組，所以標記為false
          } else if (c == '+' || c == '-') {
              // 正負號必須要在字符串的開頭或是在e/E之後
              if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                  return false;
              }
          } else {
              return false;
          }
      }
      // 如果沒有遇到數字或是e/E之後沒有數字 -> 無效
      return isDigit && numberAfterE;
  }
}
