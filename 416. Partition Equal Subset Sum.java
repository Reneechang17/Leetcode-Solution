// Medium
// DP
// O(n * target)
// Similar: 698, 473
// https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
  public boolean canPartition(int[] nums) {
      if (nums.length == 0 || nums == null) return false;

      int sum = 0;
      for (int num : nums) {
          sum += num;
      }
      if (sum % 2 != 0) return false;
      int target = sum / 2;

      int[] dp = new int[target + 1];
      for (int i = 0; i < nums.length; i++) {
          for (int j = target; j >= nums[i]; j--) {
              dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
          }

          if (dp[target] == target) return true;
      }
      return dp[target] == target;
  }
}

/**
 * DP-01背包問題：判斷一個數組是否可以被分割成兩個子集，使得兩個子集的元素總和相等
 * 
 * 在01背包問題中，通常要求是在不超過背包容量的前提下，物品的最大價值總和
 * 在這個問題中，我們的目標是看是否可以剛好填滿背包，也就是選出的數字總和是否剛好等於sum/2，如果可以，說明數組可以被分割成兩個和相等的子集
 * NOTE: 逆序遍歷，確保物品只放入一次
 **/