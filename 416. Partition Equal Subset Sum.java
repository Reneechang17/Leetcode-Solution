// Medium
// DP
// O(n * target)
// Similar: 698, 473
// https://leetcode.cn/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2; // 每份的目標是分到這個數字

        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            // 這題是01背包問題，每個元素只能取一次，所以要逆序遍歷避免重複拿
            for (int j = target; j >= nums[i]; j--) {
                // 每個元素只有選或是不選的選擇
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}

/**
 * DP-01背包問題：判斷一個數組是否可以被分割成兩個子集，使得兩個子集的元素總和相等
 * 在這個問題中，我們的目標是看是否可以剛好填滿背包，也就是選出的數字總和是否剛好等於sum/2，如果可以，說明數組可以被分割成兩個和相等的子集
 * NOTE: 逆序遍歷，確保物品只放入一次，每個元素只有選或是不選的選擇
 **/