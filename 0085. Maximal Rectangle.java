// Hard
// Stack, DP
// Time:O(m*n), Space:O(n)
// https://leetcode.cn/problems/maximal-rectangle/

import java.util.Stack;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if cur is '1', update height
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, calculateMaxArea(heights));
        }
        return maxArea;
    }

    private int calculateMaxArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        // go through each bar
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
