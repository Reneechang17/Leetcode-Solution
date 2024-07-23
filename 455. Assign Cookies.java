// Easy
// Greedy
// O(nlogn + mlogm)
// https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

class Solution {
  public int findContentChildren(int[] g, int[] s) {
      // 貪心
      // 局部最優：每一次都喂大餅乾
      // 全局最優：盡可能滿足更多小朋友
      Arrays.sort(g);
      Arrays.sort(s);

      int count = 0;
      int start = s.length - 1; // 從後向前遍歷

      for (int i = g.length - 1; i >= 0; i--) {
          if (start >= 0 && g[i] <= s[start]) {
              start--;
              count++;
          }
      }
      return count;
  }
}

/**
 * 分配餅乾
 * 這題是一個經典的貪心
 * 我們可以每一次都喂大的餅乾（局部最優），然後儘量滿足更多的小朋友（全局最優）
 **/