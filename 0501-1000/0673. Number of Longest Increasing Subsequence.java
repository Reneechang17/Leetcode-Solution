// Medium
// Array, DP
// O(n^2)
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

import java.util.Arrays;

class Solution {
  public int findNumberOfLIS(int[] nums) {
      if (nums.length == 0) return 0;
      int n = nums.length;
      int[] lengths = new int[n];
      int[] counts = new int[n];
      Arrays.fill(lengths, 1);
      Arrays.fill(counts, 1);

      int maxLength = 0;
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < i; j++) {
              if (nums[j] < nums[i]) {
                  if (lengths[j] + 1 > lengths[i]) {
                      lengths[i] = lengths[j] + 1;
                      counts[i] = counts[j];
                  } else if (lengths[j] + 1 == lengths[i]) {
                      counts[i] += counts[j];
                  }
              }
          }
          maxLength = Math.max(maxLength, lengths[i]);
      }

      int res = 0;
      for (int i = 0; i < n; i++) {
          if (lengths[i] == maxLength) {
              res += counts[i];
          }
      }
      return res;
  }
}

/**
 * 找出給定數組中最長遞增子序列（LIS）的個數
 * 這題不僅要找出最長遞增子序列的長度，還需要求出最大長度子序列有幾個
 * 
 * 這題可以透過DP+計數完成，可以維護兩個數組，一個表示到位置i的LIS長度，一個表示到位置i的LIS數量
 * 初始化兩個數組都fill為1，長度為每個元素自身，計數數組為每個元素自身構成一個序列
 * 
 * 對於每個位置i，再遍歷從0到i-1的位置j，比較nums[j]和nums[i]
 * 如果nums[j] < nums[i]，說明nums[i]可以接在nums[j]後形成LLIS
 *  如果lengths[j]+1 > lengths[i]，更新lengths[i]並設置counts[i]為counts[j]
 *  如果lengths[j]+1 == lengths[i]，將counts[j]累加到counts[i]
 * 
 * 完成遍歷後，找出lengths數組中的最大值，然後將其對應的counts數組中的值累加
 **/