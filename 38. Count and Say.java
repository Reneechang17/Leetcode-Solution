// Medium
// String
// O(n * m)
// https://leetcode.com/problems/count-and-say/

class Solution {
  public String countAndSay(int n) {
      if (n <= 0) return "";
      String res = "1";

      while (n > 1) {
          StringBuilder sb = new StringBuilder();
          int count = 1;
          for (int i = 1; i < res.length(); i++) {
              if (res.charAt(i) == res.charAt(i - 1)) {
                  count++;
              } else {
                  sb.append(count).append(res.charAt(i - 1));
                  count = 1;
              }
          }
          sb.append(count).append(res.charAt(res.length() - 1));
          res = sb.toString();
          n--;
      }
      return res;
  }
}

/**
 * 外觀數數：給定一個正整數n，生成第n項的外觀數數字符串
 * 外觀數數序列是一個整數序列，第一項是1，第二項讀作1個1，即11，第三項讀作2個1，即21，第四項讀作1個2、1個1，即1211
 * 
 * 可以逐步構建這個字符串
 * 對序列遍歷，統計連續的數字出現的次數，然後按照次數和數字的順序來構建新的字符串
 **/