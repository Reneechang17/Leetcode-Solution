// Medium
// Two Pointers
// O(len^2)
// https://leetcode.com/problems/palindromic-substrings/

class Solution {
  public int countSubstrings(String s) {
      int len = s.length();
      int res = 0;

      for (int cen = 0; cen < 2 * len - 1; cen++) {
          int left = cen / 2;
          int right = left + cen % 2;

          while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
              res++;
              left--;
              right++;
          }
      }
      return res;
  }
}

/**
 * 回文子串：給定一個字符串s，統計這個字符串中有多少個回文子串
 * 
 * 這題可以用中心擴展法，遍歷每一個字符，然後以這個字符為中心，向左右擴展，直到不是回文串為止
 * 
 * left = cen / 2表示中心點的左邊，因為cen從0開始，範圍是2*len-1，所以left = cen / 2
 * 如果cen是0，1，2，3， 則left是0，0，1，1
 * 
 * right = left + cen % 2表示中心點的右邊，因為cen是0，1，2，3，所以cen % 2是0，1，0，1
 * 當為0時，表示cen是偶數，則right = left，當為1時，表示cen是奇數，則right = left + 1
 **/