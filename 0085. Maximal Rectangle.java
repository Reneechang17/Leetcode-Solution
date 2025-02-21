// Hard
// Stack,DP
// Time:O(m*n), Space:O(n)
// https://leetcode.cn/problems/maximal-rectangle/

import java.util.Stack;

class Solution {
  // Use DP to calculate the height for each col
  // For each row, calculate the max rectangle area using monotonic stack
  public int maximalRectangle(char[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
      int m = matrix.length, n = matrix[0].length;
      int[] height = new int[n]; // 每一列的高度
      int max = 0;

      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              // 如果当前为'1'，更新高度
              height[j] = (matrix[i][j] == '1') ? height[j] + 1 : 0;
          }
          // 计算当前行的最大矩形面积
          max = Math.max(max, maxArea(height));
      }
      return max;
  }
  private int maxArea(int[] height) {
      int maxArea = 0;
      Stack<Integer> stack = new Stack<>();
      // 遍历所有柱子
      for (int i = 0; i <= height.length; i++) {
          // 如果当前柱子小于栈顶柱子高度，计算面积
          while (!stack.isEmpty() && (i == height.length || height[i] < height[stack.peek()])) {
              int h = height[stack.pop()];
              int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
              maxArea = Math.max(maxArea, h * w);
          }
          stack.push(i);
      }
      return maxArea;
  }
}

// 可以从每一行开始，利用该行的高度（该行以及其上方的连续1个数）构造直方图 -> 转化成最大矩形面积问题
//   - 可用DP思维，维护一个数组height[], 如果当前矩形中该位置为1，则更新height数组，否则重置0
// 每次构造完一行的高度后，利用单调栈计算这行的最大矩形面积
//   - 遍历所有柱子，如果当前柱子小于栈顶柱子高度，计算以栈顶元素为高度的面积，栈中存放的是柱子索引
