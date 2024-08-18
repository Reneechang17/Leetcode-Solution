// Easy
// DP, Greedy
// O(n)
// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

class Solution {
  public int findLengthOfLCIS(int[] nums) {
      if (nums.length == 0) return 0;

      int res = 1, count = 1;
      for (int i = 0; i < nums.length - 1; i++) {
          if (nums[i + 1] > nums[i]) {
              count++;
          } else {
              count = 1;
          }
          
          if (count > res) res = count;
      }
      return res;
  }
}

/**
 * 找出數組nums中最長連續遞增子序列（LIS）
 * 
 * 這題可以用DP也可以用貪心做，用貪心更好理解，可以用一次遍歷數組來實現，同時維護兩個變量res（結果）和count（當前LIS的長度）
 * 通過遍歷數組，比較相鄰的兩個元素，如果當前元素nums[i+1]大於其前一個元素nums[i]，則count自增
 * 如果不是，說明當前LIS結束，將count重置為1
 **/