// Medium
// Tree, Stack
// O(n)
// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/

import java.util.Stack;

class Solution {
  public boolean verifyPreorder(int[] preorder) {
      int low = Integer.MIN_VALUE;
      Stack<Integer> stack = new Stack<>();

      for (int num : preorder) {
          if (num < low) {
              return false;
          }
          while (!stack.isEmpty() && num > stack.peek()) {
              low = stack.pop();
          }
          stack.push(num);
      }
      return true;
  }
}

/**
 * 這題涉及兩個topics：1. 前序遍歷：中左右 2. 二叉搜索樹：小的在左邊，大的在右邊
 * 
 * 因為二叉搜索樹的特性，我們需要保證（相對於父節點）小的在左節點，大的在右節點，因此需要維護一個最小值來紀錄當前棧的最小值，也就是右節點的最小值
 * 
 * 可以用一個棧來維護，遍歷數組中的每一個元素
 * 1. 檢查當前值是否小於low，如果小於則違反搜索樹，直接返回false
 * 2. 如果當前元素大於棧頂元素，並且棧不為空，代表我們已經構建完畢左子樹，就開始構建右子樹，此時彈出棧頂元素，並且更新low的值為彈出的元素
 * 3. 把當前值壓入棧中
 **/