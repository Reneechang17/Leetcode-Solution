// Easy
// PrefixSum, Binary Search
// Time: O(nlogn) -> Sorting, O(mlogn) -> Binary Search, Space: O(n)
// https://leetcode.cn/problems/longest-subsequence-with-limited-sum/

import java.util.Arrays;

class Solution {
  // 对nums排序，求前缀和f，再通过二分找到f[i]>queries[j]的最小下标i
  // 那么和小于等于q的最长子序列长度为i - 1
  public int[] answerQueries(int[] nums, int[] queries) {
      int n = nums.length, m = queries.length;
      Arrays.sort(nums);
      int[] f = new int[n + 1];
      
      // 计算前缀和
      for (int i = 0; i < n; i++) {
          f[i + 1] = f[i] + nums[i];
      }

      int[] res = new int[m];
      for (int i = 0; i < m; i++) {
          res[i] = binarySearch(f, queries[i]) - 1;
      }
      return res;
  }

  // 具体来说前缀和数组f[k]表示数组nums排序后前k个元素的总和，通过二分查找第一个大于queries[i]的位置
  // 可以确定，在此位置之前的子序列总和是小于或等于queries[i]的
  public int binarySearch(int[] f, int target) {
      int left = 0, right = f.length - 1;
      while (left <= right) {
          int mid = (left + right) >> 1;
          if (f[mid] > target) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      return left;
  }
}
