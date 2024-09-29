// Medium
// DP
// O(n^2)
// Similar：646
// https://leetcode.cn/problems/longest-increasing-subsequence/

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;

        Arrays.fill(dp, 1);

        // dp數組表示以i結尾最長遞增子序列的長度
        for (int i = 1; i < dp.length; i++) {
            // 對於每個i，我們要找到他之前的所有元素j
            // 判斷nums[i]是否大於nums[j]，如果大於的話，則可以接在j之後
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 可以選擇要不要選擇當前i
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

/**
 * 最長遞增子序列
 * 子序列means由數組派生而來的，刪除or不刪除數組的元素都不改變其餘元素的順序
 * 
 * dp數組表示的是，以nums[i]結尾最長的遞增子序列的長度！！！（Keep in Mind！！）
 * 那麼對於每個遍歷到的nums[i]，我們要找他之前的所有元素j，因為這題要遞增，那麼我們要判斷當前的nums[i]是否大於nums[j]
 * 如果大於的話，代表這個nums[i]是可以接在nums[j]之後的，then更新dp數組
 * 
 * Note: 1. 記得用math函數動態更新res 
 * 2. dp數組幾個初始化 hint：fill..
 **/