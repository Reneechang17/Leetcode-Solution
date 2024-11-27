// Easy
// Linear Scan
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-product-of-three-numbers/

import java.util.Arrays;

class Solution {
  // 三数最大乘积的可能性：最大的三个正数、两个最小负数与最大正数的乘积
  // 可以线性扫描或排序找出，这里用线性扫描，时间空间比较高效
  public int maximumProduct(int[] nums) {
      int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
      int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

      for (int x : nums) {
          if (x < min1) {
              min2 = min1;
              min1 = x;
          } else if (x < min2) {
              min2 = x;
          }

          if (x > max1) {
              max3 = max2;
              max2 = max1;
              max1 = x;
          } else if (x > max2) {
              max3 = max2;
              max2 = x;
          } else if (x > max3) {
              max3 = x;
          }
      }
      return Math.max(min1 * min2 * max3, max1 * max2 * max3);
  }
} 

// 也可以用排序
class Solution2 {
  // Time: O(nlogn), Space: O(logn)
  public int maximumProduct(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
  }
}

// 还可以用Union Find
