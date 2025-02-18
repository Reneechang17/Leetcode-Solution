// Hard
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/largest-rectangle-in-histogram/

import java.util.Stack;

class Solution {
    // Use stack to maintain index of height in asc order
    // For each bar, pop from stack if the cur height is less than the stack'top height
    // Calculate area with the popped height as the smallest bar and update the max area
    // Push the cur index to stack, including a virtual height 0 at the end
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // pop the top
                // Width between the popped bar and the current bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
