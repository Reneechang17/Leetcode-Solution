// Medium
// Recursion
// Time:O(2^n),Space:O(2^n)
// https://leetcode.cn/problems/gray-code/

import java.util.*;

class Solution {
  public List<Integer> grayCode(int n) {
      List<Integer> res = new ArrayList<>();
      res.add(0);
      for (int i = 0; i < n; i++) {
          int curSize = res.size();
          for (int j = curSize - 1; j >= 0; j--) {
              res.add(res.get(j) | (1 << i));
          }
      }
      return res;
  }
}

// 从0到n-1逐步生成：
// 每次通过反转当前序列的数字并在前面加上对应的二进制位（即1<<i，用于生成高位）
// res.get(j) | (1 << i) 计算出将第i位1添加到原有数字中
