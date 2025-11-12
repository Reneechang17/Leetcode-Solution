// Medium
// Array
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/bulls-and-cows/

class Solution {
  public String getHint(String secret, String guess) {
      int bulls = 0, cows = 0;
      int[] numbers = new int[10]; // calculate the remaining char

      for (int i = 0; i < secret.length(); i++) {
          int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
          if (s == g) {
              bulls++;
          } else {
              // check cows
              if (numbers[s] < 0) cows++; // secret的数字在guess中
              if (numbers[g] > 0) cows++; // guess的数字在secret中
              // update count
              numbers[s]++;
              numbers[g]--;
          }
      }
      return bulls + "A" + cows + "B";
  }
}
