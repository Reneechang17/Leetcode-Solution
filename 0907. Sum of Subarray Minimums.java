// Medium
// Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/sum-of-subarray-minimums/

import java.util.*;
class Solution {
  // contribution(arr[i])=arr[i]×(i−L[i])×(R[i]−i)
  // 计算L[i]：单调递增栈维护严格小于arr[i]的索引
  //   - 遇到arr[i]时，找到左侧第一个比它小的元素索引L[i]
  // 计算R[i]：单调递增栈维护小于等于arr[i]的索引。
  //   - 遇到arr[i]时，找到右侧第一个比它小的元素索引R[i]
  public int sumSubarrayMins(int[] arr) {
      int n = arr.length, MOD = 1_000_000_007;
      int[] L = new int[n], R = new int[n];
      Deque<Integer> stack = new ArrayDeque<>();

      // compute L[i](prev less element)
      for (int i = 0; i < n; i++) {
          while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
              stack.pop();
          }
          L[i] = stack.isEmpty() ? -1 : stack.peek();
          stack.push(i);
      }
      stack.clear(); // for R[i]

      // compute R[i](next less or equal element)
      for (int i = n - 1; i >= 0; i--) {
          while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
              stack.pop();
          }
          R[i] = stack.isEmpty() ? n : stack.peek();
          stack.push(i);
      }
      long res = 0;
      for (int i = 0; i < n; i++) {
          long contribution = (long) arr[i] * (i - L[i]) * (R[i] - i);
          res = (res + contribution) % MOD;
      }
      return (int) res;
  }
}
