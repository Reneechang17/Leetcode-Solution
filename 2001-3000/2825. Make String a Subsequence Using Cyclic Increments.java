// Medium
// Two Pointers
// Time:O(n+m), Space:O(1)
// https://leetcode.cn/problems/make-string-a-subsequence-using-cyclic-increments/

class Solution {
  public boolean canMakeSubsequence(String str1, String str2) {
    // basecase
    if (str2.length() > str1.length())
      return false;
    int i = 0, j = 0;
    while (i < str1.length() && j < str2.length()) {
      if (trans(str1.charAt(i), str2.charAt(j))) {
        j++; // Match found, move to next char in str2
      }
      i++; // Always move forward in str1
    }
    return j == str2.length();
  }
  // Helper function to check cyclic increment
  private boolean trans(char c1, char c2) {
      if (c1 == c2) return true;
      return (c1 - 'a' + 1) % 26 == (c2 - 'a') % 26;
  }
}
