// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/one-edit-distance/

class Solution {
  public boolean isOneEditDistance(String s, String t) {
      if (s.equals(t)) return false;
      int m = s.length(), n = t.length();
      if (Math.abs(m - n) > 1) return false;

      if (m == n) {
          // 是否可以替换而相同
          return canOneReplace(s, t);
      } else if (m > n) {
          // 是否可以通过删除一个字符而相同
          return canOneInsert(t, s);
      } else {
          // 是否可以通过插入一个字符而相同
          return canOneInsert(s, t);
      }
  }
  private boolean canOneReplace(String s, String t) {
      boolean foundDiff = false;
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) != t.charAt(i)) {
              if (foundDiff) return false;
              foundDiff = true;
          }
      }
      return true;
  }
  private boolean canOneInsert(String shorter, String longer) {
      int i = 0, j = 0;
      while (i < shorter.length() && j < longer.length()) {
          if (shorter.charAt(i) != longer.charAt(j)) {
              if (i != j) return false; // found mismatch
              j++; // skip cur element in longer
          } else {
              i++;
              j++;
          }
      }
      return true;
  }
}

class Solution2 {
  public boolean isOneEditDistance(String s, String t) {
      int sLen = s.length(), tLen = t.length();

      if (sLen > tLen) {
        String tmp = s;
        s = t;
        t = tmp;
        sLen = s.length();
        tLen = t.length();
    }

      if (tLen - sLen > 1) return false;

      for (int i = 0; i < sLen; i++) {
          if (s.charAt(i) != t.charAt(i)) {
            if (sLen == tLen) {
                // 如果長度相同，看剩餘的部分是否相同
                  return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                // 如果長度不同，就看短的字符串剩餘部分是否等於長字符串的下一部分
                  return s.substring(i).equals(t.substring(i + 1));
              }
          }
      }
      return (sLen + 1 == tLen);
  }
}
