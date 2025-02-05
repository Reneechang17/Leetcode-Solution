// Medium
// DP
// Time:O(n^2),Space:O(n^2)
// https://leetcode.cn/problems/predict-the-winner/

class Solution {
  // dp[i][j]表示在数组间[i, j]内，玩家1与玩家2的最终分数差（最后检查是否大于等于0）
  // 玩家1在区间[i,j]有两种选择：
  //   - 选择左元素nums[i]，玩家2在区间[i+1,j]内选择，最终分差为nums[i]-dp[i+1][j]
  //   - 选择右元素nums[j]，玩家2在区间[i,j-1]内选择，最终分差为nums[j]-dp[i][j-1]
  public boolean predictTheWinner(int[] nums) {
      int n = nums.length;
      int[][] dp = new int[n][n];
      // 初始化，只有一个元素，玩家1只能拿这个数
      for (int i = 0; i < n; i++) {
          dp[i][i] = nums[i];
      }
      // 计算区间2～n的所有情况
      for (int len = 2; len <= n; len++) {
          for (int i = 0; i <= n - len; i++) {
              int j = i + len - 1;
              dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
          }
      }
      return dp[0][n - 1] >= 0;
  }
}
