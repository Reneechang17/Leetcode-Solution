// Medium
// Array, Monotonic Stack
// O(n)
// https://leetcode.com/problems/next-greater-element-ii/

import java.util.Arrays;
import java.util.Stack;

class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 2 * n; i++) {
      int num = nums[i % n];
      while (!stack.isEmpty() && nums[stack.peek()] < num) {
        res[stack.pop()] = num;
      }
      if (i < n) {
        stack.push(i);
      }
    }
    return res;
  }
}

/**
 * 下一個更大的元素II：給定一個循環數組（最後一個元素的下一個元素是數組的第一個元素），輸出每個元素的下一個更大元素
 * 數字x的下一個更大的數字是按照數組遍歷順序，這個數字之後的第一個更大的數字，這意味著需要循環搜索
 * 
 * 這題可以使用單調遞減棧來做，我們可以將數組復制一份，然後對復制的數組做兩次遍歷
 * 為了處理循環數組，我們可以對索引取模，這樣就可以處理循環的情況
 * 
 * 當棧不為空，且棧頂元素小於當前元素時，我們將棧頂元素出棧
 * 第一輪遍歷入棧，第二輪遍歷中不再壓入新元素，僅用來尋找剩餘未處理元素的下一個更大元素
 **/