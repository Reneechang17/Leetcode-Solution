// Medium
// DP
// O(N)
// https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution {
  public int mincostTickets(int[] days, int[] costs) {
      int lastDay = days[days.length - 1];
      int[] dp = new int[lastDay + 1];
      boolean[] isTravelDay = new boolean[lastDay + 1];
      for (int day : days) {
          isTravelDay[day] = true;
      }

      for (int i = 1; i <= lastDay; i++) {
          // 如果今天不需要旅行，則今天的花費與昨天相同
          if (!isTravelDay[i]) {
              dp[i] = dp[i - 1];
              continue;
          }

          // 如果今天需要旅行，計算三種通行證的最小花費
          int minCost = dp[i - 1] + costs[0]; // 從昨日花費 + 今天買1day通行證的成本
          minCost = Math.min(minCost, dp[Math.max(0, i - 7)] + costs[1]); // 從7天前的花費，今天買7days通行證的成本
          minCost = Math.min(minCost, dp[Math.max(0, i - 30)] + costs[2]); // 從30天前的花費，今天買30days通行證的成本

          dp[i] = minCost;
      }
      return dp[lastDay];
  }
}

/**
 * 要求在給定一系列旅遊日和三種不同有效期的票價中，找所有旅遊日所需要的最低成本
 * 給定一個按照遞增順序排列的整數數組days，這個數組表示你在哪些天旅行，並給定一個整數數組costs，分別表示三種有效期的票價
 * 
 * 這題可以用dp做，dp數組表示的是從第一天到第i天的最低成本
 * 首先找出lastDay，dp的數組長度為lastDay+1（因為數組索引從0開始，天數從1開始）
 * 用isTravelDay數組標記哪些日子需要旅行
 * 
 * 遍歷days數組中的每一天，計算使用每種票的總成本，取最小值
 * 如果某一天不在days數組中，那麼這天的成本就等於前一天的成本
 **/