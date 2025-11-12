// Medium
// Backtracking
// O(n!)
// https://leetcode.cn/problems/beautiful-arrangement/

class Solution {
  // 给定一个正整数n，数字1到n排列成一行，找到所有可能排列方式，使每个位置i（从1到n），要么i可以整除arr[i]，要么arr[i]可以整除i
  // 所有排列方式->通过递归构造每种可能的排列，检查是否符合条件k % i == 0 或 i % k == 0
  public int countArrangement(int n) {
      // use an array to check if the element has been used already
      boolean[] used = new boolean[n + 1];
      return backtracking(n, 1, used); // put n, k, and used
  }

  private int backtracking(int n, int k, boolean[] used) {
      if (k > n) {
          return 1; // find a valid arrangement
      }

      int count = 0;
      for (int num = 1; num <= n; num++) {
          if (!used[num] && (num % k == 0 || k % num == 0)) {
              used[num] = true;
              count += backtracking(n, k + 1, used); // move to next position
              used[num] = false; // backtracking
          }
      }
      return count;
  }
}
