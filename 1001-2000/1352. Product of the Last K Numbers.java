// Medium
// Prefix Sum
// Time:O(1),Space:O(n)
// https://leetcode.cn/problems/product-of-the-last-k-numbers/

import java.util.*;

class ProductOfNumbers {
  private List<Integer> prefix;

  public ProductOfNumbers() {
      prefix = new ArrayList<>();
      prefix.add(1);
  }
  
  public void add(int num) {
      // 任何包含0的子数组的乘积会变成0->重置前缀积
      if (num == 0) {
          prefix = new ArrayList<>();
          prefix.add(1);
      } else {
          // 计算当前前缀积
          int last = prefix.get(prefix.size() - 1);
          prefix.add(last * num);
      }
  }
  
  // 最近k个数字的乘积
  public int getProduct(int k) {
      int n = prefix.size();
      // 最近k个数字中包含至少一个0（因为前缀积数组已经被重置，无法记录超过其长度的积）
      if (k >= n) {
          return 0;
      }
      return prefix.get(n - 1) / prefix.get(n - 1 - k);
  }
}
