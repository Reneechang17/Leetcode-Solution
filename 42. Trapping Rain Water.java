// Hard
// Two Pointers: Time:O(n), Space:O(1)
// Stack: Time:O(n), Space:O(n)
// https://leetcode.cn/problems/trapping-rain-water/

import java.util.Stack;
class Solution {
    // 1. Use left and right to traverse the array from both ends
    // 2. Track the max height on the left and right with two variables
    // 3. If h[left]<h[right], update leftMax or add trapped water -> leftMax-h[left]
    // 4. If h[left]>=h[right], update rightMax or add trapped water -> rightMax-h[right]
    // 5. Repeat until left<right, return total trapped water in res
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, res = 0;
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
    // 1. Use stack to track the indices of the height
    // 2. If the cur height is greater than the height at the stack's top -> calculate water
    //    - pop the top as the bottom of the trapped water
    //    - if the stack is not empty, calculate the width and bounded height
    // 3. Push the cur index onto stack and move to the next, repeat until the arr is traversed
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0, res = 0;
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int bottom = stack.pop(); 
                if (stack.isEmpty()) {
                    break;
                }
                int width = cur - stack.peek() - 1;
                // Bounded height is Min(leftBound, rightBound) - bottom
                int bound = Math.min(height[cur], height[stack.peek()]) - height[bottom];
                res += width * bound;
            }
            stack.push(cur);
            cur++;
        }
        return res;
    }
}
