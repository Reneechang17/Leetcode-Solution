// Medium
// DP, Backtracking
// O(k^n)
// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

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
    if (sum % k != 0)
      return false;

    targetSum = sum / k;
    subsetSums = new int[k];
    Arrays.sort(nums);
    this.nums = nums;
    return dfs(nums.length - 1);
  }

  private boolean dfs(int index) {
    // 如果所有元素都已經處理，檢查每個子集的和是否都等於目標和
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
      // 避免具有相同和的子集重複放置
      if (j > 0 && subsetSums[j] == subsetSums[j - 1]) {
        continue;
      }

      // 如果當前數字加入後不超過目標和
      if (subsetSums[j] + curNum <= targetSum) {
        subsetSums[j] += curNum;
        
        // 嘗試放置下一個數字
        if (dfs(index - 1)) {
          return true;
        }
        subsetSums[j] -= curNum; // 回溯，撤銷
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