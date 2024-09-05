// Hard
// Stack
// O(n)
// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

class Solution {
  public int largestRectangleArea(int[] heights) {
      Stack<Integer> stack = new Stack<>();
      int maxArea = 0;
      int n = heights.length;

      for (int i = 0; i <= n; i++) {
          int h = (i == n ? 0 : heights[i]); // 在最後加一個高度為0的
          while (!stack.isEmpty() && h < heights[stack.peek()]) {
              int height = heights[stack.pop()];
              int width = stack.isEmpty() ? i : i - stack.peek() - 1;
              maxArea = Math.max(maxArea, height * width);
          }
          stack.push(i);
      }
      return maxArea;
  }
}

/**
 * 柱狀圖中最大的矩形：給定一個整數數組heights，其中heights[i]代表柱狀圖中第i個柱子的高度。需要找到柱狀圖中最大的矩形面積
 * 
 * 思路：用單調遞增棧，將索引壓入棧中，當遇到比棧頂元素小的元素時，開始計算矩形面積，這時候可以柱狀圖的最大可能寬度（就是i - stack.peek() - 1）
 * 計算以棧頂元素為高度的矩形面積，彈出棧頂元素並更新最大面積
 * 
 * 如果棧中還有柱狀圖，但是它們的右側沒有更矮的柱形，需要繼續計算這些柱形可以形成的面積，直到棧為空
 **/