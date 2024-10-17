// Hard
// Two Pointers, Stack
// O(n) -> Two Pointers
// O(n) -> Monotonic Stack
// https://leetcode.cn/problems/trapping-rain-water/

import java.util.Stack;

class Solution {
  public int trap(int[] height) {
    int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, res = 0;

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

/**
 * 接雨水
 * 解法1：雙指針，時間複雜度O(n)，只需要遍歷一次數組
 * 具體做法：初始化左右指針分別指向數組的開頭和結尾處，同時創建leftMax和rightMax紀錄目前為止遇到的左右最大高度
 * 當左指針小於右指針時，我們比較左指針的高度和leftMax，如果左指針的高度大於等於leftMax，則更新leftMax，否則將leftMax和左指針的高度差加到結果中
 * 反之，我們比較右指針的高度和rightMax，如果右指針的高度大於等於rightMax，則更新rightMax，否則將rightMax和右指針的高度差加到結果中
 * 最後返回結果
 **/

 class Solution2 {
  public int trap(int[] height) {
      Stack<Integer> stack = new Stack<>();
      int res = 0, cur = 0;

      while (cur < height.length) {
          while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
              int top = stack.pop();
              if (stack.isEmpty()) {
                  break;
              }
              int distance = cur - stack.peek() - 1;
              int bounded_height = Math.min(height[cur], height[stack.peek()]) - height[top];
              res += distance * bounded_height;
          }
          stack.push(cur);
          cur++;
      }
      return res;
  }
}

/**
 * 接雨水
 * 解法2：單調遞減棧
 * 具體做法：我們使用一個棧來保存每個高度的索引，當遇到一個高度大於棧頂的高度時，我們就可以計算這兩個高度之間的水量
 * 出棧的元素top是這個凹槽的最低點，當前高度cur是這個凹槽的右邊界，彈出後新的棧頂元素是這個凹槽的左邊界
 * 計算寬度：用右邊界減去左邊界再減1
 * 計算高度：高度由左右邊界中較矮的那個減去凹槽底部的高度決定
 **/
