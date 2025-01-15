class Solution {
  // Use sliding window of size k to count the num of vowels in the cur substring
  //  - For each char add in window, check if it's a vowel and update the count
  //  - Once the window size reaches k, calculate the max vowels in the window and update the result
  //  - As the window slides, remove the leftmost character and update the vowel count accordingly
  public int maxVowels(String s, int k) {
      char[] chars = s.toCharArray();
      int ans = 0, vowel = 0;
      for (int i = 0; i < s.length(); i++) {
          // add in window
          if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
              vowel++;
          }
          // if window length not k
          if (i < k - 1) {
              continue;
          }
          // update ans
          ans = Math.max(ans, vowel);
          // leave the window
          char out = chars[i - k + 1];
          if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
              vowel--;
          }
      }
      return ans;
  }
}
