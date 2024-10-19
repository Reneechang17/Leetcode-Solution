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
        subsetSums = new int[k];

        // 先排序，從最大的數字開始dfs，可以儘早查出不合法的子集
        Arrays.sort(nums); 
        this.nums = nums;
        return dfs(nums.length - 1);
    }

    private boolean dfs(int i) {
        if (i < 0) {
            for (int sum : subsetSums) {
                if (sum != targetSum) {
                    return false;
                }
            }
            return true;
        }

        int curNum = nums[i];
        for (int j = 0; j < subsetSums.length; j++) {
            // 去重，如果當前元素和前一個元素相同的話就skip
            if (j > 0 && subsetSums[j] == subsetSums[j - 1]) {
                continue;
            }
            
            // 如果放入當前的數字不會超過目標和，就繼續嘗試放入下一個數字
            if (subsetSums[j] + curNum <= targetSum) {
                subsetSums[j] += curNum;

                // dfs to next element
                if (dfs(i - 1)) {
                    return true;
                }
                subsetSums[j] -= curNum; // 撤銷
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
