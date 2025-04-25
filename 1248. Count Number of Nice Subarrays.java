// Medium
// PrefixSum
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/count-number-of-nice-subarrays/


class Solution {
  public int numberOfSubarrays(int[] nums, int k) {
      int n = nums.length;
      int[] prefixSum = new int[n + 1];
      prefixSum[0] = 1;

      int cnt = 0, res = 0;
      for (int i = 0; i < n; i++) {
          cnt += nums[i] % 2;
          if (cnt >= k) {
              res += prefixSum[cnt - k];
          }
          prefixSum[cnt]++;
      }
      return res;
  }
}
