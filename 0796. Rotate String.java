// Easy
// String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/rotate-string/

class Solution {
  // 将字符串s和自己拼接得到s+s，那么goal必定是s+s的一个子字符串
  public boolean rotateString(String s, String goal) {
      if (s.length() != goal.length()) return false;
      String doubleS = s + s;
      return doubleS.contains(goal);
  }
}
