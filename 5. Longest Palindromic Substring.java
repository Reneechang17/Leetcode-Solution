// Medium
// Two Pointers
// O(n^2)
// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1)
      return "";

    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      // odd string
      int len1 = f(s, i, i);
      // even string
      int len2 = f(s, i, i + 1);
      int len = Math.max(len1, len2);

      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int f(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}

/**
 * 時間複雜度：O(n^2) => 每個中心最多擴展兩次
 * base case：先check s是否valid
 * 思路：中心擴展法
 * 需要注意長度為奇數or偶數的情況
 * 
 * f 用雙指針來check這個len是不是回文數
 **/