// Hard
// DP, Sorting, Binary Search
// O(n logn)
// https://leetcode.com/problems/russian-doll-envelopes/

import java.util.Arrays;

class Solution {
  public int maxEnvelopes(int[][] envelopes) {
      // 先按照寬度升序排列，寬度相同則按照高度降序排列
      Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

      int[] dp = new int[envelopes.length];
      int len = 0;
      
      for (int[] envelope : envelopes) {
          int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
          if (index < 0) {
              index = -(index + 1);
          }
          dp[index] = envelope[1];
          if (index == len) {
              len++;
          }
      }
      return len;
  }
}

/**
 * 題目給定一系列信封，每個信封都有一個寬度和高度，一個信封a可以嵌套在另一個信封b裡面，如果且僅如果a的寬度和高度都小於b的寬度和高度
 * 求最多可以嵌套多少個信封
 * 
 * 這題的關鍵在於怎麼找到最長寬度和高度都遞增的序列
 * 可以利用排序，首先按照寬度對所有信封排列，如果寬度相同，則按照高度排序
 * 再利用DP找到高度的最長遞增子序列
 * 
 * 優化：在找LIS的時候可以用二分查找優化查找的效率
 **/