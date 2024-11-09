// Hard
// Two Pointers, Stack
// O(n) 
// https://leetcode.cn/problems/trapping-rain-water/

import java.util.Stack;

class Solution {
  // for this problems, we can use two pointers to keep track the left and right -> O(n)
  // and set the leftMax and rightMax to track the l/r's max height
  // and if the cur l/r is bigger then the leftMax and rightMax, then we update leftMax and rightMax
  // or we calculate the diff of max and cur to res
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

// or use stack to store the height, when cur height is bigger then the peek one
// we can calculate the water -> O(n)
class Solution2 {
  public int trap(int[] height) {
      int cur = 0, res = 0;
      Stack<Integer> stack = new Stack<>();

      while (cur < height.length) {
          while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
              int top = stack.pop(); // top是凹槽的左邊界，cur是右邊界
              if (stack.isEmpty()) {
                  break;
              }
              int dis = cur - stack.peek() - 1; // 寬度：用右邊界減去左邊界再減1
              // 高度由左右邊界中較矮的那個減去凹槽底部的高度決定
              int bound = Math.min(height[cur], height[stack.peek()]) - height[top];
              res += dis * bound;
          }
          stack.push(cur);
          cur++;
      }
      return res;
  }
}
