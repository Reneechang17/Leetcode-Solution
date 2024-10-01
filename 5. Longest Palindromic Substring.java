// Medium
// Two Pointers
// O(n^2)
// https://leetcode.cn/problems/longest-palindromic-substring/

class Solution {
  public String longestPalindrome(String s) {
      if (s == null || s.length() < 1) return "";
      
      int start = 0, end = 0;
      for (int i = 0; i < s.length(); i++) {
          int oddString = f(s, i, i);
          int evenString = f(s, i, i + 1);
          int len = Math.max(oddString, evenString);

          // end - start是當前找到的最長的回文子串的長度
          if (len > end - start) {
              // (len - 1) / 2是回文子串的左半部長度
              start = i - (len - 1) / 2;
              // len / 2是右半部分長度
              end = i + len / 2;
          }
      }
      return s.substring(start, end + 1);
  }

  private int f (String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
          // expand the window
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