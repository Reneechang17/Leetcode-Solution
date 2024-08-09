// Medium
// DP
// O(n * target)
// https://leetcode.com/problems/combination-sum-iv/

class Solution {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;

    for (int i = 0; i <= target; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i >= nums[j]) {
          dp[i] += dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }
}

/**
 * 同一個元素不同排列情況即不同組合 -> 求排列
 * 
 * 思路：外層遍歷背包，內層遍歷物品
 * 如果外循環遍歷nums(物品)，內循環遍歷背包的話，計算dp[4]時，結果集只有{1,3}，不會有{3,1}
 * 這是因為物品在外層遍歷，3只能出現在1後面
 * 
 * 本題的dp[i]表示的是湊出目標為i的排列個數有dp[i]個
 * dp[i]（此時不考慮nums[j]）由不考慮nums[j]的dp[i - nums[j]]推導出的
 **/