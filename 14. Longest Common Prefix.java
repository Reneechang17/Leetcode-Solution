// Easy
// String, prefix
// O(n * m)
// https://leetcode.cn/problems/longest-common-prefix/

class Solution {
  // find the shortest string, since the longest common prefix will not longer than the shortest string
  // seems the shortest one as LCP, and check if others string can use it as prefix
  // if not, we can cut the length, if yes, that prefix will be the LCP
  // O(n * m) -> n is the length of strs, m is the length of shortest string
  public String longestCommonPrefix(String[] strs) {
      // basecase
      if (strs == null || strs.length == 0) {
          return "";
      }

      String prefix = strs[0];
      for (String str : strs) {
          if (str.length() < prefix.length()) {
              prefix = str;
          }
      }

      for (String str : strs) {
          // 如果任何一个不能用这个prefix前缀，则缩短
          while (!str.startsWith(prefix)) {
              prefix = prefix.substring(0, prefix.length() - 1);
              
              if (prefix.isEmpty()) {
                  return "";
              }
          }
      }
      return prefix;
  }
}
