// Medium
// Math, Binary Search
// Time: O(logn), Space: O(1)
// https://leetcode.cn/problems/nth-digit/

class Solution {
  public int findNthDigit(int n) {
      long digitLength = 1, count = 9, start = 1;
      
      // 确定n在哪一段？（1位数/2位数/3位数）
      while (n > digitLength * count) {
          n -= digitLength * count;
          digitLength++;
          count *= 10;
          start *= 10;
      }

      // 计算n属于具体哪一个数字
      long num = start + (n - 1) / digitLength;

      // 计算n是num的第几位，并提取
      return String.valueOf(num).charAt((int) ((n - 1) % digitLength)) - '0';
  }
}

// 1~9 -> 1位，10~99 -> 2位，100~999 -> 3位
// 计算n属于那个数字：计算n在该位数区间的偏移量，n所属的数字
// 最后提取n在该数字中的具体字符位
