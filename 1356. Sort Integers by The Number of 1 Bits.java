// Medium
// Sort
// O(nlogn)
// https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/

import java.util.Arrays;

class Solution {
  // 将整数数组按二进制表示中的1的个数排序，如果两个数字的1的个数相同，则按数字本身的大小排序
  // 这题其实不难，主要是用不同语言中的内置函数操作
  public int[] sortByBits(int[] arr) {
      // Arrays.sort() 不能直接对 int[] 使用带有自定义 Comparator 的排序
      // 将 int[] 转换为 Integer[] 数组，然后进行排序，最后再转换回 int[]
      Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

      // 自定义排序，先按bitCount排序，再按数值本身排序
      Arrays.sort(boxedArr, (a, b) -> {
          int countA = Integer.bitCount(a);
          int countB = Integer.bitCount(b);

          if (countA != countB) {
              return countA - countB; // 按1的个数排序
          } else {
              return a - b; // 相同则按数值本身大小排序
          }
      });

      // Integer[] -> int[]
      return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
  }
}
