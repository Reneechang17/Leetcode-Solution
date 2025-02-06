// Medium
// Sliding Window
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/maximize-win-from-two-segments/

class Solution {
  public int maximizeWin(int[] prizePositions, int k) {
      int n = prizePositions.length;
      // 记录前i个元素能获得的最大奖品数->[0,1)的最优值
      int[] best = new int[n + 1];
      int maxPrizes = 0;

      int left = 0;
      for (int right = 0; right < n; right++) {
          // 保证窗口size
          // 确保right = left <= k
          while (prizePositions[right] - prizePositions[left] > k) {
              left++;
          }
          int curSize = right - left + 1;
          // 记录前缀最大值：以right结尾的区间最优解
          best[right + 1] = Math.max(best[right], curSize);
          // 计算两段区间的最大覆盖
          maxPrizes = Math.max(maxPrizes, curSize + best[left]);
      }
      return maxPrizes;
  }
}