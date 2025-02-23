// Medium
// String
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/compare-version-numbers/

class Solution {
  public int compareVersion(String version1, String version2) {
      String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
      int len1 = v1.length, len2 = v2.length, maxLen = Math.max(len1, len2);

      // compare the sub-version
      for (int i = 0; i < maxLen; i++) {
          // if one sub-version is shorter, add 0
          int num1 = (i < len1) ? Integer.parseInt(v1[i]) : 0;
          int num2 = (i < len2) ? Integer.parseInt(v2[i]) : 0;

          if (num1 > num2) {
              return 1;
          } else if (num1 < num2) {
              return -1;
          }
      }
      return 0;
  }
}
