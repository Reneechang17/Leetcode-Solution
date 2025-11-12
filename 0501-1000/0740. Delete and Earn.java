// Medium
// DP
// Time:O(n+m), Space:O(m), m is the max value in nums
// https://leetcode.cn/problems/delete-and-earn/

class Solution {
  public int deleteAndEarn(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      // find the max value 
      int max = 0;
      for (int num : nums) {
          max = Math.max(max, num);
      }
      // build total value arr
      int[] sum = new int[max + 1];
      for (int num : nums) {
          sum[num] += num;
      }
      // dp
      int pre = 0, cur = 0;
      for (int i = 0; i <= max; i++) {
          int temp = cur;
          cur = Math.max(cur, pre + sum[i]); // 选或不选当前数字
          pre = temp;
      }
      return cur;
  }
}

// 题目要求选择数组中的数字，使得所选数字的总和最大，但规则是选了某个数字后，它的前后相邻数字都会被删除
// -> 核心思想是不能选相邻的元素，类似House Robber问题
// 为了简化操作，可以统计每个数字的总价值
//   - ex. [2,2,3,3,3,4] 初始化总价值：sum = [0, 0, 0, 0, 0] 
//        - 数字 2：sum[2] += 2 -> sum = [0, 0, 2, 0, 0]
//        - 数字 2：sum[2] += 2 -> sum = [0, 0, 4, 0, 0]
//        - 数字 3：sum[3] += 3 -> sum = [0, 0, 4, 3, 0]
//        - 数字 3：sum[3] += 3 -> sum = [0, 0, 4, 6, 0]
//        - 数字 3：sum[3] += 3 -> sum = [0, 0, 4, 9, 0]
//        - 数字 4：sum[4] += 4 -> sum = [0, 0, 4, 9, 4]
// 现在问题变成：在这个总价值数组中，选择一些数字并且相邻的数字不能同时选，问如何选到最大值
// 对于每个数字，可以 1. 选当前数字：总值为上上最大值+当前数组的总价值
//                 2. 不选当前数字：总值为上一个最大值
