// Medium
// Hash Table, Math
// Time:O(1),Space:O(1)
// https://leetcode.cn/problems/reordered-power-of-2/

import java.util.*;
class Solution {
  public boolean reorderedPowerOf2(int n) {
      final long max = 1_000_000_000;
      Set<Long> set = new HashSet<>();
      int num = 1;

      // precompute all `2^x` values' hash codes using digit freq
      while (num < max) {
          set.add(getHashCode(num));
          num *= 2;
      }
      // check if hash code exists in the precomputed set
      return set.contains(getHashCode(n));
  }
  // 计算哈希值：用 10^digit的形式存储每个数字频率
  private long getHashCode(int num) {
      long temp = 0;
      while (num > 0) {
          temp += Math.pow(10, num % 10);
          num /= 10;
      }
      return temp;
  }
}
