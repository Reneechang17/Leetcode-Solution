// Medium
// Math
// O(n)
// https://leetcode.com/problems/increasing-triplet-subsequence/

class Solution {
  public boolean increasingTriplet(int[] nums) {
      int first = Integer.MAX_VALUE;
      int second = Integer.MAX_VALUE;

      for (int num : nums) {
          if (num <= first) {
              first = num;
          } else if (num <= second) {
              second = num;
          } else  {
              return true;
          }
      }
      return false;
  }
}

/**
 * 在給定的整數數組中找是否存在長度為3的遞增子序列
 * Note：遞增子序列不需要元素連續，但必須保持相對順序
 * 
 * 思路：可以用兩個變量紀錄可能的最小元素和次小元素，在遍歷中找到第三個大於second的元素，即代表找到了
 * 在遍歷數組時，對於數組中的每個num：
 * 如果num小於或等於first，就更新first為num
 * 如果num大於first且小於等於second，則更新second為num
 * 如果num大於second，則代表找到第三個元素了，直接返回true
 * 遍歷結束如果沒找到符合條件的連續子序列，則返回false
 **/