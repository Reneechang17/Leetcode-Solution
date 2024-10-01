// Medium
// Divide and Conquer
// O(n)
// https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/

class Solution {
  public int longestSubstring(String s, int k) {
      return Helper(s, 0, s.length(), k);
  }

  private int Helper(String s, int start, int end, int k) {
      if (end - start < k) {
          return 0;
      }

      // 統計每個字符的頻率
      int[] freq = new int[26];
      for (int i = start; i < end; i++) {
          freq[s.charAt(i) - 'a']++;
      }

      // 遍歷頻率數組，找頻率小於k的字符
      for (int i = start; i < end; i++) {
          if (freq[s.charAt(i) - 'a'] > 0 && freq[s.charAt(i) - 'a'] < k) {
              // 如果字符s[i]出現的頻率小於k則可以作為分割點
              int left = Helper(s, start, i, k);
              int right = Helper(s, i + 1, end, k);
              return Math.max(left, right);
          }
      }
      return end - start; // 如果所有字符出現的次數都大於等於k，則整個子串就是答案
  }
}

/**
 * 至少有K個重複字符的最長子串
 * 
 * 這題可以用分治做，思路是如果一個字符串的某個字符出現次數少於k，那麼這個字符就一定不會出現在最終的子串中
 * 因為我們可以將這個字符作為分割點，將原字符串分割成兩部分，然後分別對這兩部分進行遞歸處理
 * 如果所有字符出現的頻率都大於等於k，那麼整個子串就是答案
 **/