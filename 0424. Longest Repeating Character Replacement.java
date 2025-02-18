// Medium
// Sliding Window
// Time:O(n), Space:O(1) 
// https://leetcode.cn/problems/longest-repeating-character-replacement/

class Solution {
  // Use sliding window to track freq of chars in the cur window
  // Find the char with the max freq in the window
  // Calculate the number of replacements needed (window size - max freq)
  // If replacements needed > k, shrink window and update the max window size
  public int characterReplacement(String s, int k) {
      int[] count = new int[26];
      int left = 0, maxCount = 0, res = 0;
      for (int right = 0; right < s.length(); right++) {
          char cur = s.charAt(right);
          count[cur - 'A']++;
          maxCount = Math.max(maxCount, count[cur - 'A']);

          // calculate the num of replacements needed
          int need = (right - left + 1) - maxCount;
          if (need > k) {
              char leftChar = s.charAt(left);
              count[leftChar - 'A']--;
              left++;
          }
          res = Math.max(res, right - left + 1);
      }
      return res;
  }
}
