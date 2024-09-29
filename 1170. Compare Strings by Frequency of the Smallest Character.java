// Medium
// Binary Search
// O(m*n +k*logk)
// https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/

import java.util.Arrays;

class Solution {
  // 計算字符串的最小字母出現頻率
  private int f(String s) {
      char minChar = 'z';
      int count = 0;
      for (char c : s.toCharArray()) {
          if (c < minChar) {
              minChar = c;
              count = 1; // 更新最小字母後重新計數
          } else if(c == minChar) {
              count++; // 統計最小字母的出現次數
          }
      }
      return count;
  }


  public int[] numSmallerByFrequency(String[] queries, String[] words) {
      int n = queries.length;
      int[] res = new int[n];

      // 計算 words數組中每個字符串的最小字母頻次並排序
      int[] wordFreq = new int[words.length];
      for (int i = 0; i < words.length; i++) {
          wordFreq[i] = f(words[i]);
      }
      Arrays.sort(wordFreq);

      // 對於每個queries，用二分查找統計比f(queries)大的頻次個數
      for (int i = 0; i < queries.length; i++) {
          int queryFreq = f(queries[i]);
          res[i] = wordFreq.length - binarySearch(wordFreq, queryFreq);
      }
      return res;
  }
  
  // 找第一個比target大的索引
  private int binarySearch(int[] wordFreq, int target) {
      int left = 0, right = wordFreq.length;
      while (left < right) {
          int mid = (left + right) >> 1;
          if (wordFreq[mid] <= target) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      return left;
  }
}
