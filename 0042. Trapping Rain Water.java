// Hard
// https://leetcode.cn/problems/trapping-rain-water/

import java.util.Stack;

class Solution1 {
    // Two Pointers -> more straightforward and visualize
    // Time:O(n), Space:O(1)
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}

class Solution2 {
    // Stack
    // Time:O(n), Space:O(n)
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty())
                    break;

                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i] - height[bottom]);
                res += width * h;
            }
            stack.push(i);
        }
        return res;
    }
}
