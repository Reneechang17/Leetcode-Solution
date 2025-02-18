// Medium
// Two Pointers, Array, Sorting
// O(n logn)
// https://leetcode.com/problems/most-profit-assigning-work/

import java.util.Arrays;

class Solution {
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int n = difficulty.length;
    int[][] dp = new int[n][2];
    for (int i = 0; i < n; i++) {
      dp[i][0] = difficulty[i];
      dp[i][1] = profit[i];
    }

    Arrays.sort(dp, (a, b) -> a[0] - b[0]);

    int i = 0, total = 0, max = 0;
    Arrays.sort(worker);

    for (int work : worker) {
      while (i < n && work >= dp[i][0]) {
        max = Math.max(max, dp[i][1]);
        i++;
      }
      total += max;
    }
    return total;
  }
}

/**
 * 因為difficult和profit是綁在一起的，可以開一個二維數組紀錄，按照difficult升序排列
 * 
 * 然後遍歷worker（也排序一下）
 * 只要當前的worker的能力大於當前的difficult的話，我們就找max（和前一個max比較）
 **/