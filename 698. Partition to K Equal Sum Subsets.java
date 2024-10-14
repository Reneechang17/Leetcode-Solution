// Medium
// Backtracking
// O(k^n)
// https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/

import java.util.Arrays;

class Solution {
    private int[] nums;
    private int[] subsetSums;
    private int targetSum;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        targetSum = sum / k;
        subsetSums = new int[k]; // 用来紀錄每個子集的和

        Arrays.sort(nums); // 可以先對數組排序，從大的數字開始遞歸，儘早查出不合法的子集
        this.nums = nums;
        return dfs(nums.length - 1);
    }

    private boolean dfs(int index) {
        if (index < 0) {
            for (int sum : subsetSums) {
                if (sum != targetSum) {
                    return false;
                }
            }
            return true;
        }

        int curNum = nums[index];
        for (int j = 0; j < subsetSums.length; j++) {
            // 如果當前元素和前一個相同的話就跳過
            if (j > 0 && subsetSums[j] == subsetSums[j - 1]) {
                continue;
            }

            if (subsetSums[j] + curNum <= targetSum) {
                subsetSums[j] += curNum;

                // 遞歸處理數組下一個元素，繼續將數字分配到不同子集中
                if (dfs(index - 1)) {
                    return true;
                }
                subsetSums[j] -= curNum;
            } 
        }
        return false;
    }
}

/**
 * 將數組中的元素劃分成k個和相等的子集
 * 
 * 思路：
 * 1. 先驗證數組是否可以分成k等份，如果數組的總和不能被k整除，直接返回false
 * 2. 將數組排序（大到小），優先處理大數字，可以有效先處理可能的錯誤路徑。並計算每個子集需要達到的目標和
 * 3. 回溯：用一個數組來跟蹤每個子集當前的總和
 * 4. 遞歸：如果放入當前數字卻不超過目標和，則嘗試放入下一個數字，做完撤銷
 * Note: 需要在DFS中check是否放入相同和的子集
 **/
