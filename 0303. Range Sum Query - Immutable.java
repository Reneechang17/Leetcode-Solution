// Easy
// Prefix Sum
// O(n)
// https://leetcode.cn/problems/range-sum-query-immutable/

class NumArray {
  private int[] sum;

  public NumArray(int[] nums) {
      int n = nums.length;
      sum = new int[n + 1];
      for (int i = 0; i < n; i++) {
        sum[i + 1] = sum[i] + nums[i];
          // sum[i] = sum[i - 1] + nums[i - 1];
      }
  }
  
  public int sumRange(int left, int right) {
      return sum[right + 1] - sum[left];
  }
}

/**
 * 範圍總和查詢 - 不可變：給定一個整數數組nums，求出nums中索引在left和right之間元素的總和，包括left和right
 * 
 * 用前綴和公式先計算每個位置的前綴和，再計算區間總和。注意前綴和的索引是i + 1，因為要包括0
 * **/