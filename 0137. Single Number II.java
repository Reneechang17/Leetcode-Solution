// Medium
// Bit Manipulation 
// Time:O(n*32),Space:O(1)
// https://leetcode.cn/problems/single-number-ii/

class Solution {
  public int singleNumber(int[] nums) {
      int[] count = new int[32];
      // 统计每一位上1的个数
      for (int i = 0; i < nums.length; i++) {
          for (int j = 0; j < 32; j++) {
              count[j] += (nums[i] >> j) & 1;
          }
      }
      int res = 0;
      for (int i = 0; i < 32; i++) {
          res += (count[i] % 3) << i;
      }
      return res;
  }
}


// 由于每个数字会出现3次，每一位在所有数字中出现的次数也会是3的倍数，除了要找的那个数字
// 可以统计每一位上1出现的次数，通过取余操作找出不符合三个规律的那一位
// 用一个长度为32的数组count来统计每一位上1出现的次数，32是因为我们处理的是32位整数
// 每次处理一个数字时，将其每一位上的1加入count数组相对应位置
// 最终根据每一位count[j] % 3的结果来构建最后的数字
