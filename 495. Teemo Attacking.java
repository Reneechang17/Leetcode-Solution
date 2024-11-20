// Easy
// Simulation
// Time:O(n), Space: O(1)
// https://leetcode.cn/problems/teemo-attacking/

class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
      int ans = 0, expired = 0;
      for (int i = 0; i < timeSeries.length; i++) {
          // 如果正处于没有中毒状态 -> ans加上当前的duration
          if (timeSeries[i] >= expired) {
              ans += duration;
          } else {
              // 如果正处于中毒的状态，由于状态不能叠加
              // 本次结束时间要减去上次中毒的时间
              ans += timeSeries[i] + duration - expired;
          }

          // 更新本次中毒结束时间
          expired = timeSeries[i] + duration;
      }
      return ans;
  }
}
