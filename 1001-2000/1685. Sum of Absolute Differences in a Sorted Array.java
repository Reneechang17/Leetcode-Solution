// Medium
// Prefix
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/sum-of-absolute-differences-in-a-sorted-array/

class Solution {
  public int[] getSumAbsoluteDifferences(int[] nums) {
      int n = nums.length;
      int[] res = new int[n];
      int totalSum = 0;
      for (int num : nums) {
          totalSum += num;
      }

      int leftSum = 0;
      for (int i = 0; i < n; i++) {
          int rightSum = totalSum - leftSum - nums[i];
          res[i] = nums[i] * i - leftSum + rightSum - nums[i] * (n - i - 1);
          leftSum += nums[i]; // 更新左侧总和
      }
      return res;
  }
}

// 暴力：对于每个nums[i]，计算差值->绝对超时
// 可以用前缀和优化，对于每个nums[i]，计算nums[i]左和右侧的总和
// 对于每个nums[i]，res[i]=左侧元素的差值和+右侧元素的差值和
