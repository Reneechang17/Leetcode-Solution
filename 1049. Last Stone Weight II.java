// Medium
// DP
// O(N)
// https://leetcode.com/problems/last-stone-weight-ii/

class Solution {
  public int lastStoneWeightII(int[] stones) {
      int sum = 0;
      for (int stone : stones) {
          sum += stone;
      }

      int target = sum / 2;
      int[] dp = new int[target + 1];

      for (int i = 0; i < stones.length; i++) {
          for (int j = target; j >= stones[i]; j--) {
              dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
          }
      }
      return sum - 2 * dp[target];
  }
}

/**
 * 最後一塊石頭的重量：如何將一組石頭分割成兩堆，使得它們的總重量差最小
 * 也就是儘量把石頭分成重量相同的兩堆，相撞之後剩下的石頭最小
 * 最後剩下的就是sum - 2 * dp[target]，兩個相同可以相撞消掉，剩下的就是最小的石頭
 **/