// Medium
// Math, Binary Search, Random, Prefix Sum
// Solution(int[] w)：O(n), pickIndex()：O(logn)
// https://leetcode.com/problems/random-pick-with-weight/

import java.util.Random;

class Solution {
  private int[] s; // 前綴和數組
  private Random random = new Random();

  public Solution(int[] w) {
      int n = w.length;
      s = new int[n + 1];
      for (int i = 0; i < n; i++) {
        s[i + 1] = s[i] + w[i]; // s[i+1]表示前i+1個元素的累積和
      }
  }
  
  public int pickIndex() {
      int x = 1 + random.nextInt(s[s.length - 1]);
      int left = 1, right = s.length - 1;
      while (left < right) {
          int mid = (left + right) >> 1;
          if (s[mid] >= x) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left - 1;
  }
}

/**
 * 按照權重隨機選擇：給定一個整數數組w，每個元素表示某個索引的權重，需要根據權重來隨機選擇一個索引，權重越大的索引被選中的概率越大，也就是說權重較大的索引應該有更高的概率被選中
 * 思路：為了使每個權重對應的概率準確，可以將這個問題轉換成一個前綴和數組，再用二分查找來快速選擇
 **/